package com.wipro.datetimedemo;
import java.time.LocalDate;
import java.util.Scanner;
public class DiffDates {
    public static void getDateDiff(LocalDate dt1, LocalDate dt2) {
    	
        if (dt1.isAfter(dt2)) { 
            LocalDate temp = dt1;
            dt1 = dt2;
            dt2 = temp;
        }
        int years = dt2.getYear() - dt1.getYear();//1
        int months = dt2.getMonthValue() - dt1.getMonthValue();
        int days = dt2.getDayOfMonth() - dt1.getDayOfMonth();
        
        if (days < 0) {
            months--;
            LocalDate previousMonth = dt2.minusMonths(1);
            days += previousMonth.lengthOfMonth();
        }  
        if (months < 0) { 
            years--; 
            months += 12;
        }
        System.out.println("Difference is " + years + " years, "
        + months + " months, " + days + " days.");
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first date (yyyy-MM-dd): ");
        LocalDate dt1 = LocalDate.parse(sc.nextLine());
        System.out.print("Enter second date (yyyy-MM-dd): ");
        LocalDate dt2 = LocalDate.parse(sc.nextLine());
        getDateDiff(dt1, dt2);
         sc.close();
    }
}