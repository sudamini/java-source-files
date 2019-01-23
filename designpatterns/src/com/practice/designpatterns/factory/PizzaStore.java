package com.practice.designpatterns.factory;

public abstract class PizzaStore {
	
	protected abstract Pizza createPizza( String type );
	
	Pizza orderPizza( String type) { 
		Pizza pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	
	public static void main (String args[] ) {
		//PizzaStore nyPizzaStore = new NYPizzaStore();
		//nyPizzaStore.orderPizza("Cheese");
	}

}
