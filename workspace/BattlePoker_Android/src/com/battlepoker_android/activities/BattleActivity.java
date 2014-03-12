package com.battlepoker_android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.battlepoker_android.objects.Card;
import com.battlepoker_android.objects.Deck;
import com.battlepoker_android.objects.Enemy;
import com.example.battlepoker_android.R;

public class BattleActivity extends Activity {
	//layouts
	private ImageButton card1ImageButton;
	private ImageButton card2ImageButton;
	private ImageButton card3ImageButton;
	private ImageButton card4ImageButton;
	private ImageButton card5ImageButton;
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
		requestWindowFeature(Window.FEATURE_NO_TITLE);;
		setContentView(R.layout.activity_battle);
		enemy = (Enemy) getIntent().getSerializableExtra("com.battlepoker_android.objects.Enemy");
		card1ImageButton = (ImageButton) findViewById(R.id.card1ImageButton);
		card2ImageButton = (ImageButton) findViewById(R.id.card2ImageButton);
		card3ImageButton = (ImageButton) findViewById(R.id.card3ImageButton);
		card4ImageButton = (ImageButton) findViewById(R.id.card4ImageButton);
		card5ImageButton = (ImageButton) findViewById(R.id.card5ImageButton);
		
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
		case R.id.card1ImageButton:
			if (card1IsHeld) {
				card1IsHeld = false;
				card1ImageButton.setY(card1ImageButton.getY() + 50);//change to non-hardcoded value.
			} else {
				card1IsHeld = true;
				card1ImageButton.setY(card1ImageButton.getY() - 50);
			}
			break;
		case R.id.card2ImageButton:
			if (card2IsHeld) {
				card2IsHeld = false;
				card2ImageButton.setY(card2ImageButton.getY() + 50);
			} else {
				card2IsHeld = true;
				card2ImageButton.setY(card2ImageButton.getY() - 50);
			}
			break;
		case R.id.card3ImageButton:
			if (card3IsHeld) {
				card3IsHeld = false;
				card3ImageButton.setY(card3ImageButton.getY() + 50);
			} else {
				card3IsHeld = true;
				card3ImageButton.setY(card3ImageButton.getY() - 50);
			}
			break;
		case R.id.card4ImageButton:
			if (card4IsHeld) {
				card4IsHeld = false;
				card4ImageButton.setY(card4ImageButton.getY() + 50);
			} else {
				card4IsHeld = true;
				card4ImageButton.setY(card4ImageButton.getY() - 50);
			}
			break;
		case R.id.card5ImageButton:
			if (card5IsHeld) {
				card5IsHeld = false;
				card5ImageButton.setY(card5ImageButton.getY() + 50);
			} else {
				card5IsHeld = true;
				card5ImageButton.setY(card5ImageButton.getY() - 50);
			}
			break;
		//for testing only----------
//		case R.id.button1:			
//			//MapActivity.battleSuccessful = true;
//			this.finish();
//			break;
//
//		case R.id.button2:
//			//MapActivity.battleSuccessful = false;
//			this.finish();
//			break;
		//--------------------------

		default:
			break;
		}
	}

}
