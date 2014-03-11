package com.battlepoker_android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.battlepoker_android.objects.Card;
import com.battlepoker_android.objects.Deck;
import com.battlepoker_android.objects.Enemy;
import com.example.battlepoker_android.R;

public class BattleActivity extends Activity {
	//layouts
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;
	private Card card5;
	//this can be done better if each card is an object.
	private boolean card1IsHeld = false;
	private boolean card2IsHeld = false;
	private boolean card3IsHeld = false;
	private boolean card4IsHeld = false;
	private boolean card5IsHeld = false;

	//private boolean battleSuccessful = false;
	private Enemy enemy;

	//iterate through each level and update the level states
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battle);
		enemy = (Enemy) getIntent().getSerializableExtra("com.battlepoker_android.objects.Enemy");
		card1 = (Card) findViewById(R.id.card1);
		card2 = (Card) findViewById(R.id.card2);
		card3 = (Card) findViewById(R.id.card3);
		card4 = (Card) findViewById(R.id.card4);
		card5 = (Card) findViewById(R.id.card5);
		
		//Each battle will draw a new deck
		Deck deck = new Deck();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
		
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.card1:
			if (card1IsHeld) {
				card1IsHeld = false;
				card1.setY(card1.getY() + 50);//change to non-hardcoded value.
			} else {
				card1IsHeld = true;
				card1.setY(card1.getY() - 50);
			}
			break;
		case R.id.card2:
			if (card2IsHeld) {
				card2IsHeld = false;
				card2.setY(card2.getY() + 50);
			} else {
				card2IsHeld = true;
				card2.setY(card2.getY() - 50);
			}
			break;
		case R.id.card3:
			if (card3IsHeld) {
				card3IsHeld = false;
				card3.setY(card3.getY() + 50);
			} else {
				card3IsHeld = true;
				card3.setY(card3.getY() - 50);
			}
			break;
		case R.id.card4:
			if (card4IsHeld) {
				card4IsHeld = false;
				card4.setY(card4.getY() + 50);
			} else {
				card4IsHeld = true;
				card4.setY(card4.getY() - 50);
			}
			break;
		case R.id.card5:
			if (card5IsHeld) {
				card5IsHeld = false;
				card5.setY(card5.getY() + 50);
			} else {
				card5IsHeld = true;
				card5.setY(card5.getY() - 50);
			}
			break;
		//for testing only----------
		case R.id.button1:			
			//MapActivity.battleSuccessful = true;
			this.finish();
			break;

		case R.id.button2:
			//MapActivity.battleSuccessful = false;
			this.finish();
			break;
		//--------------------------

		default:
			break;
		}
	}

}
