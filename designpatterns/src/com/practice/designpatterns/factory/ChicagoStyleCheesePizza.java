package com.practice.designpatterns.factory;

public class ChicagoStyleCheesePizza extends Pizza {
	
	public ChicagoStyleCheesePizza() {
		name = "Chicago Style Sauce and Cheese Pizza";
		dough = "Thick Crust Dough";
		sauce = "Plum tomato Sauce";
		
		toppings.add("Mozarella Cheese");
	}
	
	void cut() {
		System.out.println( "Cut into square pieces");
	}
}
