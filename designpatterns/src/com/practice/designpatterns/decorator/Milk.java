package com.practice.designpatterns.decorator;

public class Milk extends CondimentDecorator {
	
	Beverage beverage;
	
	public Milk(Beverage beverage2) {
		beverage = beverage2;
	}

	@Override
	protected double getCost() {
		return 0.10 + beverage.getCost();
	}

	@Override
	protected void setCost(double cst) {
		// TODO Auto-generated method stub
		
	}
	
	protected String getDescription() {
		return description;
	}


}
