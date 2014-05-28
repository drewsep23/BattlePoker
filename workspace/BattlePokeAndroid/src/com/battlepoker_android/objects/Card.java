package com.battlepoker_android.objects;
import com.battlepoker_android.objects.*;

public class Card {

	private String number;
	private String suit;
	private boolean isHeld;
	private ImageLocation location;

	public Card(String number, String suit, int aX, int aY, int aWidth, int aHeight) {
		this.suit = suit;
		this.number = number;
		this.location = new ImageLocation(aX,aY,aWidth,aHeight);
		
		//initialize to false
		setHeld(false);
	}
	
	public int getX(){
		return this.location.x;
	}
	
	public int getY(){
		return this.location.y;
	}
	
	public int getWidth(){
		return this.location.width;
	}
	
	public int getHeight(){
		return this.location.height;
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
