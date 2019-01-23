package com.practice.designpatterns.strategy;

public class KnifeBehaviour implements WeaponBehaviour {

	@Override
	public void useWeapon() {
		System.out.println( "I cut with a knife" ) ;

	}

}
