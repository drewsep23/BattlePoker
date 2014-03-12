package com.battlepoker_android.objects;

public class Card {

	private String number;
	private String suit;
	private boolean isHeld;

	public Card(String number, String suit) {
		this.suit = suit;
		this.number = number;
		//initialize to false
		setHeld(false);
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isHeld() {
		return isHeld;
	}

	public void setHeld(boolean isHeld) {
		this.isHeld = isHeld;
	}

}
