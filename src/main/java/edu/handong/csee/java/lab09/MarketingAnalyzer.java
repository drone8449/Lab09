package edu.handong.csee.java.lab09; // package name

import java.util.Scanner; // import Scanner Class
import java.util.ArrayList;  // import ArrayList Class

/**
 * This program is made for analyzing marketing sales of employee
 * 
 * @author 21700184
 *
 */
public class MarketingAnalyzer { // make public class 'MarketingAnalyzer'

	private String name; // declare string name
	private double sales; // declare double sales

	/**
	 * This is method for getting name
	 * 
	 * @return name
	 */
	public String getName() { // make public method 'getName'
		return name; // return name value
	}

	/**
	 * This is method for getting sales
	 * 
	 * @return sales
	 */
	public double getSales() { // make public method 'getSales'
		return sales; // return sales value
	}

	/**
	 * This is method for setting name
	 * 
	 * @param n is name
	 */
	public void setName(String n) { // make public method 'setName', and parameter is n
		name = n; // name is n
	}

	/**
	 * This is method for setting sales
	 * 
	 * @param s is sales
	 */
	public void setSales(double s) { // make public method 'setSales', and parameter is s
		sales = s; // sales is s
	}

	private double highestSales; // declare double highestSales
	private double averageSales; // declare double averageSales
	private ArrayList<MarketingAnalyzer> team; // declare ArrayList team

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) { // main method
		MarketingAnalyzer analyzer = new MarketingAnalyzer(); // declare object 'analyzer' to use MarketingAnalyzer Class

		analyzer.getData(); // call getData()
		analyzer.computeAverage(); // call computeAverage()
		analyzer.computeHighestSales(); // call computeHighestSales()
		analyzer.printResults(); // call printResults()
	}

	/**
	 * This is method for getting data
	 */
	public void getData() { // make public method 'getData'
		System.out.println("Enter the name and sales of salesmen: "); // print message 'Enter the number of salesmen: '
		Scanner mykeyboard = new Scanner(System.in); // declare object 'mykeyboard' to use Scanner Class

		team = new ArrayList<MarketingAnalyzer>(); // allocate ArrayList 'team' in memory

	    boolean done = false; // declare boolean variable 'done', having false value
	    
		while (!done) { // repeat 
			System.out.print("Name? "); // print message 'Name? '
			String name = mykeyboard.nextLine(); // input value is name
			System.out.print("Sales? "); // print message 'Sales? '
			double sales = mykeyboard.nextDouble(); // input value is sales
			MarketingAnalyzer t = new MarketingAnalyzer();  // declare object 't' to use MarketingAnalyzer
			t.setName(name); // name value store to t.setName
			t.setSales(sales); // sales value store to t.setSales
			team.add(t); // t's values add to ArrayList 'team'
			System.out.print("Do you want to get additional data?"); // print message 'Do you want to get additional data?'
			mykeyboard.nextLine(); // get enter value 
			String ans = mykeyboard.nextLine(); // input value is 'ans'
			if(!ans.equalsIgnoreCase ("yes")) // if 'ans' is not 'yes'
				done = true; // done have true value
		}
	}

	/**
	 * This is method for computing average
	 */
	public void computeAverage() { // make public method 'computeAverage'
		double sum = 0; // declare double sum
     
		for (int i = 0; i < team.size(); i++) { // repeat i times from 0 to team.size()
			sum = sum + team.get(i).getSales(); // get everyone's sales
		}

		averageSales = sum / team.size(); // get average sales
	}

	/**
	 * This is method for computing highestSales
	 */
	public void computeHighestSales() { // make public method 'computeHighestSales'
		double highestSales = 0; // declare double highestSales

		for (int i = 0; i < team.size(); i++) { // repeat i times from 0 to team.size()
			if (highestSales < team.get(i).getSales()) // if team.get(i).getSales is bigger than anything else
				highestSales = team.get(i).getSales(); // get highestSales
		}

		this.highestSales = highestSales; // highestSales is Class MarketingAnalyzer's variable 'highestSales'
	}

	/**
	 * This is method for printing results
	 */
	public void printResults() { // make public method 'printResults'
		System.out.println("Average: " + averageSales); // print average of sales

		System.out.println("Salesmen who has the highest sales: "); // print message "Salesmen who has the highest sales: "

		for (int i = 0; i < team.size(); i++) { // repeat i times from 0 to team.size()
			if (team.get(i).getSales() == highestSales) { // if get highestSales team
				System.out.println("Name: " + team.get(i).getName()); // print highestSales team name
				System.out.println("Sales: " + team.get(i).getSales()); // print highestSales team's sales
			}
		}
	}
}