package com.wipro.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springdemo.beans.College;
import com.wipro.springdemo.beans.Department;
import com.wipro.springdemo.beans.Mobile;

public class App2 {

	    public static void main(String[] args) {
	    	
	        ApplicationContext ctx = new AnnotationConfigApplicationContext(App2.class);
	        Mobile mobile = ctx.getBean(Mobile.class);
	        System.out.println(mobile);
	    }
	}


