package com.practice.designpatterns.decorator;

public class MiniBeverageSimulator {

	public static void main ( String args[] ) {
		
		// espresso with no condiments
		Beverage beverage1 = new Espresso();
		System.out.println( beverage1.getDescription() + " $" + beverage1.getCost() );
		
		// Dark roast with milk and whip
		Beverage beverage2 = new DarkRoast(); /* make a dark roast object */
		beverage2 = new Milk(beverage2); /* wrap it with a beverage object */
		beverage2 = new Whip ( beverage2 ); /* wrap it with a whip object */
		System.out.println( beverage2.getDescription() + " $" + beverage2.getCost() );
		
		
	}
}
