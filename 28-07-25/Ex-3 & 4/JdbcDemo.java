package com.WiproA.jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcDemo
{
	  static String url="jdbc:mysql://localhost:3306/wiprojdbc";
	  static String userId="root";
	  static String passWord="Aviksql@253";
	  
      static void printData()//PRINT DATA
      {
   	Connection conn;
		try {
			conn = DriverManager.getConnection(url, userId, passWord);
			Statement stmt= conn.createStatement();   	
	    	String sql="select * from student";
	    	ResultSet rs=stmt.executeQuery(sql);
	    	while(rs.next())
	    	{
	    		System.out.println("id="+ rs.getInt(1)+" name="+ rs.getString(2)+" roll number="+ rs.getString(3));
	 	    	}	
		} catch (SQLException e) {
			e.printStackTrace();
		}   	   
   }

     static void insertData()//INSERT DATA
     {
   	  try {
			Connection conn= DriverManager.getConnection(url, userId, passWord);
			String sql="insert into student (student_name,roll_number) values(?,?)";
			PreparedStatement ps=conn.prepareStatement(sql);
			Scanner sc= new Scanner(System.in);
			System.out.println("Please enter name:");
			String studentName=sc.next();
			System.out.println("Please enter roll number:");
			String rollNumber=sc.next();
			ps.setString(1, studentName);
			ps.setString(2, rollNumber);
			ps.executeUpdate();  
   	  } catch (SQLException e) {
			e.printStackTrace();
		} 	     	  
     }

    public static void main( String[] args ) //MAIN METHOD
    {
    	Scanner sc= new Scanner(System.in);	
    	do {
    	System.out.println("--Menu----");	
    	System.out.println("--1. Print ---");	
       	System.out.println("--2. Add Data ---");
       	System.out.println("--3. Exit ---");
       	int option=sc.nextInt();
       	switch(option)
       	{
       	case 1:
       		printData();
       		break;
       	case 2: 
       		insertData();
       		break;
       	case 3:	System.out.println("APPLICATION CLOSED");
       			return;
       	default:
       		System.out.println("Invalid Option"); 		
       	}   	
    	}while(true);  
    }
 }
 
