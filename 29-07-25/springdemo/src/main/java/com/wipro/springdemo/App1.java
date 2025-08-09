package com.wipro.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springdemo.beans.College;
import com.wipro.springdemo.beans.Department;

public class App1 {

	    public static void main(String[] args) {

	        
	    	  ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	          College c = (College) ctx.getBean("college");
	          System.out.println(c);
	    	
//	        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//	        Mobile mobile = ctx.getBean(Mobile.class);
//	        System.out.println(mobile);
	    }
	}


