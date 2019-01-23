package com.practice.designpatterns.strategy;

public class MiniCharacterSimulator {
	
	protected static final String KING = "King";
	protected static final String QUEEN = "Queen";
	protected static final String KNIGHT = "Knight";
	protected static final String TROLL = "Troll";
	
	public static void main ( String args[] ) {
		
		// create all characters. The type of character can be changed at runtime
		//e.g. Character king = new Queen();
		
		Character king = new King();
		Character queen = new Queen();
		Character knight = new Knight();
		Character troll = new Troll();
		
		king.setWeapon(new BowAndArrowBehaviour()); 
		king.setName(KING);
		king.fight();
		
		king.setWeapon(new SwordBehaviour()); 
		king.fight();
		
		king = queen;
		queen.setWeapon(new AxeBehaviour()); 
		queen.setName(QUEEN);
		queen.fight();
		
		queen = troll;
		troll.setWeapon(new KnifeBehaviour()); 
		troll.setName(TROLL);
		troll.fight();
	}

}
