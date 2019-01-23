package com.practice.designpatterns.strategy;

public class SwordBehaviour implements WeaponBehaviour {

	@Override
	public void useWeapon() {
		System.out.println( "I fight with a sword.");

	}

}
