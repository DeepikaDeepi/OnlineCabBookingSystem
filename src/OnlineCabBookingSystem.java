import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.cab.booking.IBookingManager;
import com.cab.booking.ISession;
import com.cab.booking.IUser;
import com.cab.booking.implementation.BookingManager;
import com.cab.booking.implementation.Fleet;
import com.cab.booking.implementation.Session;
import com.cab.booking.implementation.SessionManager;
import com.cab.booking.implementation.User;
import com.cab.booking.implementation.UserManager;


public class OnlineCabBookingSystem 
{

	class Instance implements Runnable
	{
		IBookingManager bookingMgr;
		int serviceCode;
		int threadNum;
		public Instance(IBookingManager bookingMgr, int serviceCode, int threadNum) 
		{
			this.bookingMgr = bookingMgr;
			this.serviceCode = serviceCode;
			this.threadNum = threadNum;
		}

		@Override
		public void run() {
			System.out.println("Created a new thread: " + this.threadNum + " for a new incoming user request!");
			//Dont know if this is right!!!
			Scanner sc = new Scanner(System.in);
			if(this.serviceCode == 1)
			{
				int opReq = 9999;
				System.out.println("Enter UserID: ");
				String userName = sc.nextLine();
				System.out.println("Enter Password: ");
				String password = sc.nextLine();
				if(this.bookingMgr.login(userName, password))
				{
					System.out.println("Login successful!");
					IUser user = UserManager.getInstance().getUser(userName);
					String sessionID = SessionManager.getInstance().createSession();
					ISession session = new Session();
					session.setLoggedInUser(user);
					session.setSessionID(Long.valueOf(sessionID));
					if("Customer".equalsIgnoreCase(user.getUserType()))
					{
					System.out.println("Press 1 to book a cab. \n"
							+ "Press 2 to cancel a cab booking. \n"
							+ "Press 3 to edit profile info. \n"
							+ "Press 4 to show profile info. \n"
							+ "Press 5 to delete your profile. \n"
							+ "Press 6 to see your booking history. \n"
							+ "Press 7 to see see all cabs in system. \n"
							+ "Press 8 to see all available cabs. \n"
							+ "Press 0 to logout!");
					}
					else if("Cabbie".equalsIgnoreCase(user.getUserType()))
					{
						System.out.println("Press 1 to register a cab. \n"
								+ "Press 2 to  a unregister booking. \n"
								+ "Press 0 to logout!");
					}
					while(true)
					{
						opReq = sc.nextInt();
						if(opReq == 0)
						{
							break;
						}
						if("Customer".equalsIgnoreCase(user.getUserType()))
						{
							this.performCustomerAction(sc, opReq, user);
							System.out.println("\nDo you want to perform any other operation? Please enter the code: ");
							continue;
						}
						else if("Cabbie".equalsIgnoreCase(user.getUserType()))
						{
							this.performCabbieAction(sc, opReq, user);
							System.out.println("\nDo you want to perform any other operation? Please enter the code: ");
							continue;
						}
						else
						{
							System.out.println("Invalid user type.");
							break;
						}
							
					}
				}
			}
		}

		/**
		 * @param sc
		 * @param opReq
		 * @param user
		 */
		private void performCustomerAction(Scanner sc, int opReq, IUser user) {
			if(opReq == 1)
			{
				System.out.println("Enter cab number to book: ");
				String cabNo = sc.nextLine();
				System.out.println("Enter date of booking in DD/MM/YYYY format: ");
				String date = sc.nextLine();
				System.out.println("Your booking ID for the booking is: " + this.bookingMgr.bookCab(cabNo, user, date));
				return;
			}
			else if(opReq == 2)
			{
				System.out.println("Enter booking ID you want to cancel: ");
				String bookingID = sc.nextLine();
				this.bookingMgr.cancelCab(bookingID, user);
				return;
			}
			else if(opReq == 3)
			{
				System.out.println("Enter your new email ID: ");
				String emailID = sc.nextLine();
				System.out.println("Enter any changes in your name: ");
				String fullName = sc.nextLine();
				IUser updatedUser = new User(user.getUserID(), user.getPassword(), emailID, user.getGender(), fullName, user.getUserType());
				UserManager.getInstance().editUserInfo(updatedUser);
				return;
			}
			else if(opReq == 4)
			{
				UserManager.getInstance().showUserInfo(user.getUserID());
				return;
			}
			else if(opReq == 5)
			{
				UserManager.getInstance().deleteUser(user);
				return;
			}
			else if(opReq == 6)
			{
				UserManager.getInstance().showBookingHistory(user);
				return;
			}
			else if(opReq == 7)
			{
				Fleet.getInstance().showAllCabs();
				return;
			}
			else if(opReq == 8)
			{
				Fleet.getInstance().showAvailableCabs();
				return;
			}
			else
			{
				System.out.println("Invalid request!");
				return;
			}
		}
		
		/**
		 * @param sc
		 * @param opReq
		 * @param user
		 */
		private void performCabbieAction(Scanner sc, int opReq, IUser user) {
			if(opReq == 1)
			{
				System.out.println("Enter cab number you want to register: ");
				String cabNo = sc.nextLine();
				System.out.println("Enter cab type (mini/sedan/luxury): ");
				String cabType = sc.nextLine();
				System.out.println("Enter cab's minimum fare: ");
				double minFare = sc.nextDouble();
				boolean status = Fleet.getInstance().registerCab(cabType, minFare, cabNo);
				System.out.println(status ? "Cab registration successfull!" : "Oops! Something went wrong, please try again.");
				return;
			}
			else if(opReq == 2)
			{
				System.out.println("Enter cab number to unregister: ");
				String cabNo = sc.nextLine();
				Fleet.getInstance().unregisterCab(cabNo);
				return;
			}
			else
			{
				System.out.println("Invalid request!");
				return;
			}
		}
		
	}
	
	public static void main(String[] args) 
	{
		ExecutorService es = Executors.newFixedThreadPool(10);
		Scanner sc = new Scanner(System.in);
		OnlineCabBookingSystem ocbs = new OnlineCabBookingSystem();
		int serviceCode = 0; int threadNum = 0;
		System.out.println("Press 1 to login. \nPress 2 to register.");
		while(true)
		{
			serviceCode = sc.nextInt();
			if(serviceCode == 1 || serviceCode == 3)
			{
				Instance newThread = ocbs.new Instance(new BookingManager(), serviceCode, threadNum++);
				es.execute(newThread);
			}
			else
			{
				System.out.println("Sorry, no such service is available.");
			}
		}
	}

}
