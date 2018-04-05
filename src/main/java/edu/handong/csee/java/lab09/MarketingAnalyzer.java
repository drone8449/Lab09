package edu.handong.csee.java.lab09;

import java.util.Scanner;     // import Scanner Class

public class MarketingAnalyzer {
	
	private String name;
	private double sales;
	
	public String getName() {
		return name;
	}
	
	public double getSales() {
		return sales;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setSales(double s) {
		sales = s;
	}
	
	private double highestSales;
	private double averageSales;
	private MarketingAnalyzer[] team;

	public static void main(String[] args) {
	   MarketingAnalyzer analyzer = new MarketingAnalyzer();

	   analyzer.getData();
	   analyzer.computeAverage();
	   analyzer.computeHighestSales();
	   analyzer.printResults();
	}
    
	public void getData(){
	   System.out.println("Enter the number of salesmen: ");
	   Scanner mykeyboard = new Scanner(System.in);

	   int numOfSalesmen = mykeyboard.nextInt();

	   team = new MarketingAnalyzer[numOfSalesmen];

	   for(int i=0; i < numOfSalesmen; i++){
	      System.out.println("Enter data for associate number: " + (i+1));
	      System.out.print("Name? ");
	      mykeyboard.nextLine();
	      String name = mykeyboard.nextLine();
	      System.out.print("Sales? ");
	      double sales = mykeyboard.nextDouble();
	      team[i] = new MarketingAnalyzer();
	      team[i].setName(name);
	      team[i].setSales(sales);
	   }
	}

	public void computeAverage(){
	   double sum = 0;

	   for(int i = 0; i < team.length; i++){
	      sum = sum + team[i].getSales();
	   }

	   averageSales = sum/team.length;
	}

	public void computeHighestSales(){
	   double highestSales = 0;

	   for(int i = 0; i < team.length; i++){
	      if(highestSales < team[i].getSales())
	         highestSales = team[i].getSales();
	   }

	   this.highestSales = highestSales;
	}

	public void printResults(){
	   System.out.println("Average: " + averageSales);

	   System.out.println("Salesmen who has the highest sales: ");

	   for(int i = 0; i < team.length; i++){
	      if(team[i].getSales() == highestSales){
	         System.out.println("Name: " + team[i].getName());
	         System.out.println("Sales: " + team[i].getSales());
	      }
	   }
	}

}