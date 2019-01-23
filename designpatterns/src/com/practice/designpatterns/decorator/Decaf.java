package com.practice.designpatterns.decorator;

public class Decaf extends Beverage {
	
	protected Decaf () {
		description = "Decaf";
	}

	@Override
	protected double getCost() {
		return 1.05;
	}

	@Override
	protected void setCost(double cst) {
		// TODO Auto-generated method stub
		
	}

}
