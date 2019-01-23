package com.practice.designpatterns.decorator;

public class Whip extends CondimentDecorator {
	
	Beverage beverage;
	
	public Whip(Beverage beverage2) {
		beverage = beverage2;
	}

	@Override
	protected double getCost() {
		return 0.10 + beverage.getCost();
	}

	@Override
	protected void setCost(double cst) {
		
	}
	
	protected String getDescription() {
		return description;
	}


}
