package com.practice.designpatterns.factory;

public abstract class PizzaFactory {
	
	Pizza pizza;
	
	void createPizza() {
		
	}

	Pizza createPizza(String type) {
		return pizza;
	}

}
