package com.wipro.hibernatedemo;
import java.util.List;
import java.util.Scanner;
import com.wipro.hibernatedemo.entity.Pan;
import com.wipro.hibernatedemo.repo.PanRepo;

public class App 
{
    public static void main( String[] args )
    {   	
    	int choice=0;
    	do {
    	System.out.println("--Menu---");
    	System.out.println("1.--Create Pan---");
    	System.out.println("2.--Find by Pan Id---");
    	System.out.println("3.--Update Pan---");
    	System.out.println("4.--Delete by  Pan id---");
    	System.out.println("5.--Find All Pan---");
    	System.out.println("6.--Find All Pan Names---");
    	System.out.println("7.--Find By Pan Number---");
    	System.out.println("9.--Exit---");
    	Scanner sc= new Scanner(System.in);    	
    	  choice= sc.nextInt();
    	 	
	    	switch(choice)
	    	{
	    		case 1:
	    			PanRepo.createPan();
	    		break;
	    		case 2:
	    			System.out.println("Please enter PAN id:");
	    			int id= sc.nextInt();
	    			Pan p=PanRepo.findById(id);
	    			System.out.println(p);   
	    			break;
	    		case 3:
	    			PanRepo.updatePan();
	    			break;    			
	    		case 4:  			 
	    			System.out.println("Please enter PAN id:");
	    			int id1= sc.nextInt();
	    			PanRepo.deleteById(id1);
	    			break;   			
	    		case 5:
	    			List<Pan> list=PanRepo.findAll();
	    			System.out.println(list);
	    			break;
	    		case 6:
	    			List<String> panNameList=PanRepo.findAllPanNames();
	    			System.out.println(panNameList);
	    			break;
	    		case 7:
	    			System.out.println("Please enter PAN Number");
	    			String language=sc.next();
	    			List<Pan> listPan= PanRepo.findByPanNumber(language);
	    			System.out.println(listPan);
	    			break;
	    		case 9:
	    			return;
	    		
	    		default:
	    			System.out.println("Invalid option please try again");
	    			break;	    	
	    	 }        	 
    	}while(choice!=9);
    }
}

