package com.battlepoker_android.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> deck = new ArrayList<Card>();

	public Deck() {		
		deck.add(new Card("A","h",1200,290,100,145));
		deck.add(new Card("2","h",0,290,100,145));
		deck.add(new Card("3","h",100,290,100,145));
		deck.add(new Card("4","h",200,290,100,145));
		deck.add(new Card("5","h",300,290,100,145));
		deck.add(new Card("6","h",400,290,100,145));
		deck.add(new Card("7","h",500,290,100,145));
		deck.add(new Card("8","h",600,290,100,145));
		deck.add(new Card("9","h",700,290,100,145));
		deck.add(new Card("1","h",800,290,100,145));
		deck.add(new Card("J","h",900,290,100,145));
		deck.add(new Card("Q","h",1000,290,100,145));
		deck.add(new Card("K","h",1100,290,100,145));
		deck.add(new Card("A","s",1200,0,100,145));
		deck.add(new Card("2","s",0,0,100,145));
		deck.add(new Card("3","s",100,0,100,145));
		deck.add(new Card("4","s",200,0,100,145));
		deck.add(new Card("5","s",300,0,100,145));
		deck.add(new Card("6","s",400,0,100,145));
		deck.add(new Card("7","s",500,0,100,145));
		deck.add(new Card("8","s",600,0,100,145));
		deck.add(new Card("9","s",700,0,100,145));
		deck.add(new Card("1","s",800,0,100,145));
		deck.add(new Card("J","s",900,0,100,145));
		deck.add(new Card("Q","s",1000,0,100,145));
		deck.add(new Card("K","s",1100,0,100,145));
		deck.add(new Card("A","c",1200,145,100,145));
		deck.add(new Card("2","c",0,145,100,145));
		deck.add(new Card("3","c",100,145,100,145));
		deck.add(new Card("4","c",200,145,100,145));
		deck.add(new Card("5","c",300,145,100,145));
		deck.add(new Card("6","c",400,145,100,145));
		deck.add(new Card("7","c",500,145,100,145));
		deck.add(new Card("8","c",600,145,100,145));
		deck.add(new Card("9","c",700,145,100,145));
		deck.add(new Card("1","c",800,145,100,145));
		deck.add(new Card("J","c",900,145,100,145));
		deck.add(new Card("Q","c",1000,145,100,145));
		deck.add(new Card("K","c",1100,145,100,145));
		deck.add(new Card("A","d",1200,435,100,145));
		deck.add(new Card("2","d",0,435,100,145));
		deck.add(new Card("3","d",100,435,100,145));
		deck.add(new Card("4","d",200,435,100,145));
		deck.add(new Card("5","d",300,435,100,145));
		deck.add(new Card("6","d",400,435,100,145));
		deck.add(new Card("7","d",500,435,100,145));
		deck.add(new Card("8","d",600,435,100,145));
		deck.add(new Card("9","d",700,435,100,145));
		deck.add(new Card("1","d",800,435,100,145));
		deck.add(new Card("J","d",900,435,100,145));
		deck.add(new Card("Q","d",1000,435,100,145));
		deck.add(new Card("K","d",1100,435,100,145));

		Collections.shuffle(deck);

	}

	public Card drawCard() {
		Card myCard;
		myCard = this.deck.get(0);
		deck.remove(0);
		return myCard;
	}

}
