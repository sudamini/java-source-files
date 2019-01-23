package com.practice.designpatterns.decorator;

public abstract class Beverage {
	
	String description;
	double cost;
	
	protected String getDescription() {
		return description;
	}
	
	protected void setDescription( String desc ) {
		this.description = desc;
	}
	
	protected abstract double getCost();
		
	
	protected abstract void setCost( double cst ); 
	

}
