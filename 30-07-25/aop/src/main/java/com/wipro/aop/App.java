package com.wipro.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.wipro.aop.exception.NoSeatAvailableException;
import com.wipro.aop.service.AirTravelProcess;
//This annotation tells Spring to scan the specified package for beans annotated with @Component, @Service, @Repository, etc.
//It automatically registers them in the application context.
@ComponentScan("com.wipro.aop")
//This annotation enables AOP support in Spring. It allows methods to be intercepted using aspects,
//such as logging, security, or exception handling.
@EnableAspectJAutoProxy
public class App {

    public static void main(String[] args) {
    	//Creates a Spring application context using App.class as configuration.
    	//Since App contains @ComponentScan and @EnableAspectJAutoProxy, it sets up the context accordingly.
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
      //Fetches the AirTravelProcess bean from the Spring container.
        AirTravelProcess airService = ctx.getBean(AirTravelProcess.class); 

        try {
            airService.docheckIn(true);
            airService.collectBoardingPass();
            airService.doSecurityCheck();
            airService.doBoarding();
        } catch (NoSeatAvailableException e) {
            System.out.println("Contact Airline Manager");
        }
    }
}
