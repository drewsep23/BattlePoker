package com.battlepoker_android.objects;

import java.io.Serializable;

public class Enemy implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int health;
	private int mana;
	public Card [] hand;
	
	public Enemy(){
		hand = new Card [5];
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}


}
