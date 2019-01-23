package com.practice.designpatterns.decorator;

public class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	protected Mocha(Beverage bvrg ) {
		this.beverage = bvrg;
	}

	@Override
	protected double getCost() {
		return 0.20 + beverage.getCost();
	}

	@Override
	protected void setCost(double cst) {
		
	}
	
	protected String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

}
