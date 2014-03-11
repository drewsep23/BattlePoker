package com.battlepoker_android.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	public List<String> cards = new ArrayList<String>();

	public Deck() {
		cards.add("Ah");
		cards.add("2h");
		cards.add("3h");
		cards.add("4h");
		cards.add("5h");
		cards.add("6h");
		cards.add("7h");
		cards.add("8h");
		cards.add("9h");
		cards.add("1h");
		cards.add("Jh");
		cards.add("Qh");
		cards.add("Kh");
		cards.add("As");
		cards.add("2s");
		cards.add("3s");
		cards.add("4s");
		cards.add("5s");
		cards.add("6s");
		cards.add("7s");
		cards.add("8s");
		cards.add("9s");
		cards.add("1s");
		cards.add("Js");
		cards.add("Qs");
		cards.add("Ks");
		cards.add("Ac");
		cards.add("2c");
		cards.add("3c");
		cards.add("4c");
		cards.add("5c");
		cards.add("6c");
		cards.add("7c");
		cards.add("8c");
		cards.add("9c");
		cards.add("1c");
		cards.add("Jc");
		cards.add("Qc");
		cards.add("Kc");
		cards.add("Ad");
		cards.add("2d");
		cards.add("3d");
		cards.add("4d");
		cards.add("5d");
		cards.add("6d");
		cards.add("7d");
		cards.add("8d");
		cards.add("9d");
		cards.add("1d");
		cards.add("Jd");
		cards.add("Qd");
		cards.add("Kd");

		Collections.shuffle(cards);

	}

	public String drawCard() {
		String myCard;
		myCard = this.cards.get(0);
		cards.remove(0);
		return myCard;
	}

}
