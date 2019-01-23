package com.practice.designpatterns.factory;

public class SimplePizzaFactory extends PizzaFactory {

	
	@Override
	public Pizza createPizza(String type) {
		/*if ( type.equals("Cheese")) {
			pizza = new CheesePizza();
		} else if ( type.equals("Pepperoni")) {
			pizza = new PepperoniPizza();
		} else if ( type.equals("Veggie")) {
			pizza = new VeggiePizza();
		}*/
		return null;
	}

	@Override
	public void createPizza() {
		
		
	}

}
