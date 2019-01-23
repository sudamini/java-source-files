package com.practice.designpatterns.decorator;

public class Espresso extends Beverage {
	
	protected Espresso() {
		description = "Espresso";
	}

	@Override
	protected double getCost() {
		return 1.99;
	}

	@Override
	protected void setCost(double cst) {
		// TODO Auto-generated method stub
		
	}

}
