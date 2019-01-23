package com.practice.designpatterns.strategy;

public class BowAndArrowBehaviour implements WeaponBehaviour {

	@Override
	public void useWeapon() {
		System.out.println( "I shoot with a Bow and an Arrow!");
	}

}
