package com.practice.designpatterns.decorator;

public class DarkRoast extends Beverage {

	protected DarkRoast() {
		description = "Dark Roast";
	}
	
	@Override
	protected double getCost() {
		return 0.99;
	}

	@Override
	protected void setCost(double cst) {
		
	}

}
