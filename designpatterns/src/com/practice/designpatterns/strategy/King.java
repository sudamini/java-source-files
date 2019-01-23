package com.practice.designpatterns.strategy;

public class King extends Character {
	
	
	protected King() {
		System.out.println( "Creating " + name + "object. ");
	}
	
	/* We may override this method from superclass if we want to provide more specific fighting behaviour to our characters.
	 * 
	public void fight() {
		System.out.println( "I am " + name + ". " );
		weapon.useWeapon();
	}**/

}
