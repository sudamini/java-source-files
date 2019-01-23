package com.practice.designpatterns.strategy;

public class AxeBehaviour implements WeaponBehaviour {

	@Override
	public void useWeapon() {
		System.out.println( "I fight with an axe. ");

	}

}
