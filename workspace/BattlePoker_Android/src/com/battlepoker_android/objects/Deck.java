package com.battlepoker_android.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<Card> deck = new ArrayList<Card>();

	public Deck() {		
		deck.add(new Card("A","h"));
		deck.add(new Card("2","h"));
		deck.add(new Card("3","h"));
		deck.add(new Card("4","h"));
		deck.add(new Card("5","h"));
		deck.add(new Card("6","h"));
		deck.add(new Card("7","h"));
		deck.add(new Card("8","h"));
		deck.add(new Card("9","h"));
		deck.add(new Card("1","h"));
		deck.add(new Card("J","h"));
		deck.add(new Card("Q","h"));
		deck.add(new Card("K","h"));
		deck.add(new Card("A","s"));
		deck.add(new Card("2","s"));
		deck.add(new Card("3","s"));
		deck.add(new Card("4","s"));
		deck.add(new Card("5","s"));
		deck.add(new Card("6","s"));
		deck.add(new Card("7","s"));
		deck.add(new Card("8","s"));
		deck.add(new Card("9","s"));
		deck.add(new Card("1","s"));
		deck.add(new Card("J","s"));
		deck.add(new Card("Q","s"));
		deck.add(new Card("K","s"));
		deck.add(new Card("A","c"));
		deck.add(new Card("2","c"));
		deck.add(new Card("3","c"));
		deck.add(new Card("4","c"));
		deck.add(new Card("5","c"));
		deck.add(new Card("6","c"));
		deck.add(new Card("7","c"));
		deck.add(new Card("8","c"));
		deck.add(new Card("9","c"));
		deck.add(new Card("1","c"));
		deck.add(new Card("J","c"));
		deck.add(new Card("Q","c"));
		deck.add(new Card("K","c"));
		deck.add(new Card("A","d"));
		deck.add(new Card("2","d"));
		deck.add(new Card("3","d"));
		deck.add(new Card("4","d"));
		deck.add(new Card("5","d"));
		deck.add(new Card("6","d"));
		deck.add(new Card("7","d"));
		deck.add(new Card("8","d"));
		deck.add(new Card("9","d"));
		deck.add(new Card("1","d"));
		deck.add(new Card("J","d"));
		deck.add(new Card("Q","d"));
		deck.add(new Card("K","d"));

		Collections.shuffle(deck);

	}

	public Card drawCard() {
		Card myCard;
		myCard = this.deck.get(0);
		deck.remove(0);
		return myCard;
	}

}
