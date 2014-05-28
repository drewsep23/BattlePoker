package com.battlepoker_android.objects;

public class Player {

	private String name;
	private int health;
	private int mana;
	private int x;
	private int y;
	public Card [] hand;

	public Player(int health, int mana) {
		hand = new Card [5];
		x = 0;
		y = 0;
		this.health = health;
		this.mana = mana;
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

	public int getXPosition() {
		return x;
	}

	public void setXPosition(int xPosition) {
		this.x = xPosition;
	}

	public int getYPosition() {
		return y;
	}

	public void setYPosition(int yposition) {
		this.y = yposition;
	}



}
