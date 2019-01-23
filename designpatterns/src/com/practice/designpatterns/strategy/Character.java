package com.practice.designpatterns.strategy;

public abstract class Character {
	
	//each character has a WeaponBehaviour
	protected WeaponBehaviour weapon;
	
	//each character has a name
	protected String name;
	
	protected WeaponBehaviour getWeapon() {
		return weapon;
	}

	protected void setWeapon(WeaponBehaviour weapon) {
		this.weapon = weapon;
	}

	protected void fight() {
		System.out.println( "I am " + name + ". " );
		weapon.useWeapon();
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}
}
