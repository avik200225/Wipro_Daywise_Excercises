package com.wipro.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import com.wipro.springdemo.beans.Mobile;

@Configuration
@ComponentScan("com.wipro.springdemo.beans")
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        Mobile mobile = ctx.getBean(Mobile.class);
        System.out.println(mobile);
    }
}
