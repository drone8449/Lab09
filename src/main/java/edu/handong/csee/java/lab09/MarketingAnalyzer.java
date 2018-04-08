package edu.handong.csee.java.lab09; // package name

import java.util.Scanner; // import Scanner Class

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
	 * @param n
	 *            is name
	 */
	public void setName(String n) { // make public method 'setName', and parameter is n
		name = n; // name is n
	}

	/**
	 * This is method for setting sales
	 * 
	 * @param s
	 *            is sales
	 */
	public void setSales(double s) { // make public method 'setSales', and parameter is s
		sales = s; // sales is s
	}

	private double highestSales; // declare double highestSales
	private double averageSales; // declare double averageSales
	private MarketingAnalyzer[] team; // declare Array team

	/**
	 * main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) { // main method
		MarketingAnalyzer analyzer = new MarketingAnalyzer(); // declare object 'analyzer' to use MarketingAnalyzer
																// Class

		analyzer.getData(); // call getData()
		analyzer.computeAverage(); // call computeAverage()
		analyzer.computeHighestSales(); // call computeHighestSales()
		analyzer.printResults(); // call printResults()
	}

	/**
	 * This is method for getting data
	 */
	public void getData() { // make public method 'getData'
		System.out.println("Enter the number of salesmen: "); // print message 'Enter the number of salesmen: '
		Scanner mykeyboard = new Scanner(System.in); // declare object 'mykeyboard' to use Scanner Class

		int numOfSalesmen = mykeyboard.nextInt(); // input value is numOfSalesmen

		team = new MarketingAnalyzer[numOfSalesmen]; // make array object 'team'

		for (int i = 0; i < numOfSalesmen; i++) { // repeat i times from 0 to numOfSalesmen
			System.out.println("Enter data for associate number: " + (i + 1)); // print message 'Enter data for
																				// associate number: ' and
			System.out.print("Name? "); // print message 'Name? '
			mykeyboard.nextLine(); // get 'enter' value
			String name = mykeyboard.nextLine(); // input value is name
			System.out.print("Sales? "); // print message 'Sales? '
			double sales = mykeyboard.nextDouble(); // input value is sales
			team[i] = new MarketingAnalyzer(); // make object 'MarketingAnalyzer'
			team[i].setName(name); // set the name
			team[i].setSales(sales); // set the Sales
		}
	}

	/**
	 * This is method for computing average
	 */
	public void computeAverage() { // make public method 'computeAverage'
		double sum = 0; // declare double sum

		for (int i = 0; i < team.length; i++) { // repeat i times from 0 to team.length
			sum = sum + team[i].getSales(); // get everyone's sales
		}

		averageSales = sum / team.length; // get average sales
	}

	/**
	 * This is method for computing highestSales
	 */
	public void computeHighestSales() { // make public method 'computeHighestSales'
		double highestSales = 0; // declare double highestSales

		for (int i = 0; i < team.length; i++) { // repeat i times from 0 to team.length
			if (highestSales < team[i].getSales()) // if team[i].getSales is bigger than anything else
				highestSales = team[i].getSales(); // get highestSales
		}

		this.highestSales = highestSales; // highestSales is Class MarketingAnalyzer's variable 'highestSales'
	}

	/**
	 * This is method for printing results
	 */
	public void printResults() { // make public method 'printResults'
		System.out.println("Average: " + averageSales); // print average of sales

		System.out.println("Salesmen who has the highest sales: "); // print message "Salesmen who has the highest
																	// sales: "

		for (int i = 0; i < team.length; i++) { // repeat i times from 0 to team.length
			if (team[i].getSales() == highestSales) { // if get highestSales team
				System.out.println("Name: " + team[i].getName()); // print highestSales team name
				System.out.println("Sales: " + team[i].getSales()); // print highestSales team's sales
			}
		}
	}
}