package com.wipro.aop.service;
import org.springframework.stereotype.Component;

import com.wipro.aop.exception.NoSeatAvailableException;

@Component //@Component is a Spring annotation used to mark a Java class as a Spring-managed bean.

public class AirTravelProcess{
		
	public void docheckIn(boolean seatAvailable) throws NoSeatAvailableException {
	    // System.out.println("Doing Check in");
	    if (!seatAvailable) {
	        throw new NoSeatAvailableException("No seat available for check-in: ");
	    }
	    System.out.println("Check-in successful.");
	}
		
		public void collectBoardingPass()
		{
			System.out.println("Collecting Boarding Pass");
		}
		
		public void doSecurityCheck()
		{
			System.out.println("Doing Security Check");
		}
		public void doBoarding()
		{
			System.out.println("Boarding");
		}
	}

