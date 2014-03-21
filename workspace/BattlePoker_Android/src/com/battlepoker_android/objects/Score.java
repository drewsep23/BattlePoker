package com.battlepoker_android.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Score {

	private static boolean isFlush(Card[] myHand) {
		for (int i = 1; i <= 4; i++) {
			if (myHand[0].getSuit() != (myHand[i].getSuit())) {
				return false;
			}
		}
		return true;
	}

	private static boolean isStraight(Card[] myHand) {
		String[] swapHand = new String[5];

		for (int i = 0; i < 5; i++) {
			swapHand[i] = myHand[i].getNumber();
		}

		List<String> aHand = new ArrayList<String>(Arrays.asList(swapHand));
		if (aHand.contains("A") && aHand.contains("2") && aHand.contains("3") && aHand.contains("4") && aHand.contains("5")) {
			return true;
		}
		if (aHand.contains("6") && aHand.contains("2") && aHand.contains("3") && aHand.contains("4") && aHand.contains("5")) {
			return true;
		}
		if (aHand.contains("6") && aHand.contains("7") && aHand.contains("3") && aHand.contains("4") && aHand.contains("5")) {
			return true;
		}
		if (aHand.contains("6") && aHand.contains("7") && aHand.contains("8") && aHand.contains("4") && aHand.contains("5")) {
			return true;
		}
		if (aHand.contains("6") && aHand.contains("7") && aHand.contains("8") && aHand.contains("9") && aHand.contains("5")) {
			return true;
		}
		if (aHand.contains("6") && aHand.contains("7") && aHand.contains("8") && aHand.contains("9") && aHand.contains("1")) {
			return true;
		}
		if (aHand.contains("J") && aHand.contains("7") && aHand.contains("8") && aHand.contains("9") && aHand.contains("1")) {
			return true;
		}
		if (aHand.contains("J") && aHand.contains("Q") && aHand.contains("8") && aHand.contains("9") && aHand.contains("1")) {
			return true;
		}
		if (aHand.contains("J") && aHand.contains("Q") && aHand.contains("K") && aHand.contains("9") && aHand.contains("1")) {
			return true;
		}
		if (aHand.contains("J") && aHand.contains("Q") && aHand.contains("K") && aHand.contains("A") && aHand.contains("1")) {
			return true;
		}
		return false;
	}

	private static boolean isPair(Card[] myHand) {
		int next = 0;
		for (int i = 0; i < 4; i++) {
			next++;
			for (int j = next; j < 5; j++) {
				if (myHand[i].getNumber().equals(myHand[j].getNumber())) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isHighPair(Card[] myHand) {
		int next = 0;
		for (int i = 0; i < 4; i++) {
			next++;
			for (int j = next; j < 5; j++) {
				if (myHand[i].getNumber().equals(myHand[j].getNumber())) {
					if (myHand[i].getNumber().equals("A") || myHand[i].getNumber().equals("K") || myHand[i].getNumber().equals("Q") || myHand[i].getNumber().equals("J")) {
						return true;
					}
				}
			}
		}
		return false;
	}

	//Two pair will return true if FullHouse is present
	private static boolean isTwoPair(Card[] myHand) {
		int next = 0;
		for (int i = 0; i <= 3; i++) {
			next++;
			for (int j = next; j <= 4; j++) {
				if (myHand[i].getNumber().equals(myHand[j].getNumber())) {
					List<Card> aHand = new ArrayList<Card>(Arrays.asList(myHand));
					aHand.remove(i);
					aHand.remove(j - 1);
					if (aHand.get(0).getNumber().equals(aHand.get(1).getNumber()) || aHand.get(0).getNumber().equals(aHand.get(2).getNumber())
							|| aHand.get(1).getNumber().equals(aHand.get(2).getNumber())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean isThreeOfKind(Card[] myHand) {
		int next = 0;
		for (int i = 0; i < 3; i++) {
			next++;
			for (int j = next; j < 4; j++) {
				if (myHand[i].getNumber().equals(myHand[j].getNumber())) {
					if (j < 4) {
						int g = j + 1;
						while (g <= 4) {
							if (myHand[j].getNumber().equals(myHand[g].getNumber())) {
								return true;
							}
							g++;
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean isFourOfKind(Card[] myHand) {
		int next = 0;
		for (int i = 0; i < 4; i++) {
			next++;
			for (int j = next; j < 5; j++) {
				if (myHand[i].getNumber().equals(myHand[j].getNumber())) {
					if (j < 4) {
						int g = j + 1;
						while (g <= 4) {
							if (myHand[j].getNumber().equals(myHand[g].getNumber())) {
								if (g < 4) {
									int k = g + 1;
									while (k <= 4) {
										if (myHand[g].getNumber().equals(myHand[k].getNumber())) {
											return true;
										}
										k++;
									}
								}
							}
							g++;
						}
					}
				}
			}
		}
		return false;
	}

	private static boolean isFullHouse(Card[] myHand) {
		String card1 = "j", card2 = "j";
		for (int i = 0; i < 4; i++) {
			for (int g = 1; g < 5; g++) {
				if (!myHand[i].getNumber().equals(myHand[g].getNumber())) {
					card1 = myHand[i].getNumber();
					card2 = myHand[g].getNumber();
				}
			}
		}
		for (int k = 0; k < 4; k++) {
			if (!myHand[k].getNumber().equals(card1) && !myHand[k].getNumber().equals(card2)) {
				return false;
			}
		}
		return true;
	}

	public static int getScore(Card[] aHand) {

		if (isFlush(aHand) && isStraight(aHand)) {
			String[] subHand = new String[5];
			for (int i = 0; i <= 4; i++) {
				subHand[i] = aHand[i].getNumber();
			}
			List<String> handList = new ArrayList<String>(Arrays.asList(subHand));
			if (handList.contains("K") && handList.contains("A")) {
				return 2500;
			}
		}

		if (isFlush(aHand) && isStraight(aHand)) {
			return 500;
		}
		if (isFourOfKind(aHand)) {
			return 250;
		}
		if (isFullHouse(aHand)) {
			return 90;
		}
		if (isFlush(aHand)) {
			return 60;
		}
		if (isStraight(aHand)) {
			return 40;
		}
		if (isThreeOfKind(aHand)) {
			return 30;
		}
		if (isTwoPair(aHand)) {
			return 20;
		}
		if (isHighPair(aHand)) {
			return 15;
		}
		if (isPair(aHand)) {
			return 10;
		}
		return 0;

	}

}
