package edu.handong.csee.java.lab09;   // package name

import java.util.Scanner;     // import Scanner Class

public class MarketingAnalyzer {    // make public class 'MarketingAnalyzer'
	
	private String name;   // declare string name
	private double sales;   // declare double sales
	
	public String getName() {   // make public method 'getName'
		return name;   // return name value
	}
	
	public double getSales() {   // make public method 'getSales'
		return sales;   // return sales value
	}
	
	public void setName(String n) {   // make public method 'setName', and parameter is n
		name = n;   // name is n 
	}
	
	public void setSales(double s) {   // make public method 'setSales', and parameter is s
		sales = s;   // sales is s
	}
	
	private double highestSales;   // declare double highestSales
	private double averageSales;   // declare double averageSales
	private MarketingAnalyzer[] team;   // declare Array team

	public static void main(String[] args) {   // main method
	   MarketingAnalyzer analyzer = new MarketingAnalyzer();  // declare object 'analyzer' to use MarketingAnalyzer Class

	   analyzer.getData();    // call getData()
	   analyzer.computeAverage();   // call computeAverage()
	   analyzer.computeHighestSales();   // call computeHighestSales()
	   analyzer.printResults();   // call printResults()
	}
    
	public void getData(){   // make public class 'getData'
	   System.out.println("Enter the number of salesmen: ");   // print message 'Enter the number of salesmen: ' 
	   Scanner mykeyboard = new Scanner(System.in);   // declare object 'mykeyboard' to use Scanner Class

	   int numOfSalesmen = mykeyboard.nextInt();   // input value is numOfSalesmen

	   team = new MarketingAnalyzer[numOfSalesmen];   // make array object 'team'

	   for(int i=0; i < numOfSalesmen; i++){  // repeat i times from 0 to numOfSalesmen
	      System.out.println("Enter data for associate number: " + (i+1));   // print message 'Enter data for associate number: ' and 
	      System.out.print("Name? ");   // print message 'Name? '
	      mykeyboard.nextLine();   // get 'enter' value
	      String name = mykeyboard.nextLine();   // input value is name
	      System.out.print("Sales? ");   // print message 'Sales? '
	      double sales = mykeyboard.nextDouble();  // input value is sales
	      team[i] = new MarketingAnalyzer();   // make object 'MarketingAnalyzer'
	      team[i].setName(name);  // set the name
	      team[i].setSales(sales);   // set the Sales
	   }
	}

	public void computeAverage(){   // make public class 'computeAverage'
	   double sum = 0;   // declare double sum

	   for(int i = 0; i < team.length; i++){   // repeat i times from 0 to team.length
	      sum = sum + team[i].getSales();   //  get everyone's sales
	   }

	   averageSales = sum/team.length;   //  get average sales 
	}

	public void computeHighestSales(){   // make public class 'computeHighestSales'
	   double highestSales = 0;   // declare double highestSales

	   for(int i = 0; i < team.length; i++){   // repeat i times from 0 to team.length
	      if(highestSales < team[i].getSales())   // if team[i].getSales is bigger than anything else
	         highestSales = team[i].getSales();   // get highestSales
	   }

	   this.highestSales = highestSales;   // highestSales is Class MarketingAnalyzer's variable 'highestSales'
	}

	public void printResults(){   // make public class 'printResults'
	   System.out.println("Average: " + averageSales);  // print average of sales

	   System.out.println("Salesmen who has the highest sales: ");  // print message "Salesmen who has the highest sales: "

	   for(int i = 0; i < team.length; i++){    // repeat i times from 0 to team.length
	      if(team[i].getSales() == highestSales){   // if get highestSales team
	         System.out.println("Name: " + team[i].getName());   // print highestSales team name
	         System.out.println("Sales: " + team[i].getSales());   // print highestSales team's sales
	      }
	   }
	}
}