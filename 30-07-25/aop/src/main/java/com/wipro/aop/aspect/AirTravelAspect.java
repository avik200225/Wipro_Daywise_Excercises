package com.wipro.aop.aspect;
import org.springframework.stereotype.Component;
import com.wipro.aop.exception.NoSeatAvailableException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect //marks the class as an aspect.
@Component  //makes it a Spring-managed bean so AOP can apply it.
public class AirTravelAspect {
	//@Before, @After, @Around, @AfterThrowing
	//These annotations are used inside a class marked with @Aspect. 
	//They specify when your code (called advice) runs relative to the target method.
//	@Before	Just before target method runs
//	@After	After method runs (whether success/failure)
//	@AfterReturning	After method runs successfully
//	@AfterThrowing	After method throws an exception
//	@Around	Before and after, gives full control
	
	 @Before("execution(* com..AirTravelProcess.docheckIn(..))")
	    public void showPhotoId() {
	        System.out.println("Please show your Photo ID before check-in");
	    }
	    @Before("execution(* com.wipro.aop.service.AirTravelProcess.doSecurityCheck(..)))")
	    public void collectBoardingPass() {
	        System.out.println("Please show your Boarding Pass before Security Check");
	    }
	    @Before("execution(* com.wipro.aop.service.AirTravelProcess.doBoarding(..))")
	    public void showBoardingPass() {
	        System.out.println("Please show your Boarding Pass before Boarding");
	    }

	    @AfterThrowing(pointcut = "execution(* com.wipro.aop.service.AirTravelProcess.docheckIn(..))", throwing = "ex")
	    public void NoSeatException(NoSeatAvailableException ex) {
	        System.out.println("Exception during check-in: " + ex.getMessage());
	    }
}
