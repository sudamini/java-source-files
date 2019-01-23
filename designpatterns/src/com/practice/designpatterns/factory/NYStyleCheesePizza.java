package com.practice.designpatterns.factory;

public class NYStyleCheesePizza extends Pizza {
	
	public NYStyleCheesePizza() {
		name = "NY Style Sauce and Cheese Pizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		
		toppings.add("Grated Cheese");
	}
	
	void cut() {
		System.out.println( "Cut into triangular pieces");
	}
}
