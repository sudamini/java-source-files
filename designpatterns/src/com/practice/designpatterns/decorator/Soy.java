package com.practice.designpatterns.decorator;

public class Soy extends CondimentDecorator {
	
	Beverage beverage;
	// tall 10, grande 15, venti 20
	@Override
	protected double getCost() {
		return 0.15 + beverage.getCost();
	}

	@Override
	protected void setCost(double cst) {
		// TODO Auto-generated method stub
		
	}
	
	protected String getDescription() {
		return description;
	}


}
