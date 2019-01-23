package com.practice.designpatterns.decorator;

public class HouseBlend extends Beverage {

	protected HouseBlend() {
		description = "House Blend";
	}
	
	@Override
	protected double getCost() {
		return 0.89;
	}

	@Override
	protected void setCost(double cst) {
		// TODO Auto-generated method stub
		
	}

}
