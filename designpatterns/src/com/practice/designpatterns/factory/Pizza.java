package com.practice.designpatterns.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {
	
	Pizza pizza;
	String name;
	String dough;
	String sauce;
	List<String> toppings = new ArrayList<String>();
	
	void prepare() {
		System.out.println( "Preparing a dough");
	}
	void bake() {
		System.out.println( "Baking a dough");
		
	}
	void cut() {
		System.out.println( "Cutting pizza");
	}
	void box(){
		System.out.println( "Boxing");
	}
	
	Pizza orderPizza( String type) {
		PizzaFactory factory = new SimplePizzaFactory();
		Pizza pizza = factory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	public String getName() {
		return name;
	}

}
