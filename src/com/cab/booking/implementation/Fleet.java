package com.cab.booking.implementation;

import java.util.ArrayList;
import java.util.List;

import com.cab.booking.ICab;
import com.cab.booking.IFleet;

public class Fleet implements IFleet 
{

	private static Fleet INSTANCE;
	
	private final List<ICab> allCabs = new ArrayList<ICab>();
	
	private final List<ICab> availableCabs = new ArrayList<ICab>();
	
	private final Object lock = new Object();
	
	public static synchronized Fleet getInstance()
	{
		if(Fleet.INSTANCE == null)
		{
			Fleet.INSTANCE = new Fleet();
		}
		return Fleet.INSTANCE;
	}
	
	@Override
	public boolean registerCab(String cabType, double minFare, String cabNo) {
		synchronized (lock) {
			ICab cab = new Cab(cabNo, cabType, minFare);
			return allCabs.add(cab) || availableCabs.add(cab);
		}
	}

	@Override
	public boolean unregisterCab(String cabNo) {
		synchronized (lock) {
			ICab cabToDel = null;
			for(ICab cab : this.allCabs)
			{
				if(cab.getCabNo().equals(cabNo))
				{
					cabToDel = cab;
					break;
				}
			}
			boolean status = this.allCabs.remove(cabToDel) || this.availableCabs.remove(cabToDel);
			return status;
		}
	}

	@Override
	public void showAvailableCabs() {
		System.out.println("List of available cabs: ");
		synchronized (lock) {
			for(ICab cab : this.availableCabs)
			{
				System.out.println("Cab No: " + cab.getCabNo() + ", Cab Type: " + cab.getCabType() + " , Min Fare - " + cab.getMinFare());
			}
		}
	}

	@Override
	public void showAllCabs() {
		System.out.println("List of all cabs: ");
		synchronized (lock) {
			for(ICab cab : this.allCabs)
			{
				System.out.println("Cab No: " + cab.getCabNo() + ", Cab Type: " + cab.getCabType() + " , Min Fare - " + cab.getMinFare());
			}
		}		
	}

	@Override
	public boolean isCabAvailable(String cabNo) {
		synchronized (lock) {
			for(ICab cab : this.allCabs)
			{
				if(cab.getCabNo().equals(cabNo))
				{
					return cab.isAvailable();
				}
			}
			return false;
		}
	}

	@Override
	public void updateAvailableCabs(String cabNo, boolean availStatus) {
		
		ICab cabToDel = null;
		
		for(ICab cab : this.availableCabs)
		{
			if(cab.getCabNo().equals(cabNo))
			{
				cabToDel = cab;
				break;
			}
		}		
		this.availableCabs.remove(cabToDel);
		this.allCabs.get(this.allCabs.indexOf(cabToDel)).setAvailable(availStatus);
	}

	@Override
	public boolean isValidCab(String cabNo) {
		synchronized (lock) {
			for(ICab cab : this.allCabs)
			{
				if(cab.getCabNo().equals(cabNo))
				{
					return true;
				}
			}
			return false;
		}
	}

}
