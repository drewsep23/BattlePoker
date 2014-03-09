package com.battlepoker_android.src;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;

import com.example.battlepoker_android.R;

public class Battle extends Activity {
	private LinearLayout card1LinearLayout;
	private LinearLayout card2LinearLayout;
	private LinearLayout card3LinearLayout;
	private LinearLayout card4LinearLayout;
	private LinearLayout card5LinearLayout;
	private boolean card1IsHeld = false;
	private boolean card2IsHeld = false;
	private boolean card3IsHeld = false;
	private boolean card4IsHeld = false;
	private boolean card5IsHeld = false;

	//iterate through each level and update the level states
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battle);

		card1LinearLayout = (LinearLayout) findViewById(R.id.card1LinearLayout);
		card2LinearLayout = (LinearLayout) findViewById(R.id.card2LinearLayout);
		card3LinearLayout = (LinearLayout) findViewById(R.id.card3LinearLayout);
		card4LinearLayout = (LinearLayout) findViewById(R.id.card4LinearLayout);
		card5LinearLayout = (LinearLayout) findViewById(R.id.card5LinearLayout);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.card1LinearLayout:
			if (card1IsHeld) {
				card1IsHeld = false;
				card1LinearLayout.setY(card1LinearLayout.getY() + 50);
			} else {
				card1IsHeld = true;
				card1LinearLayout.setY(card1LinearLayout.getY() - 50);
			}
			break;
		case R.id.card2LinearLayout:
			if (card2IsHeld) {
				card2IsHeld = false;
				card2LinearLayout.setY(card2LinearLayout.getY() + 50);
			} else {
				card2IsHeld = true;
				card2LinearLayout.setY(card2LinearLayout.getY() - 50);
			}
			break;
		case R.id.card3LinearLayout:
			if (card3IsHeld) {
				card3IsHeld = false;
				card3LinearLayout.setY(card3LinearLayout.getY() + 50);
			} else {
				card3IsHeld = true;
				card3LinearLayout.setY(card3LinearLayout.getY() - 50);
			}
			break;
		case R.id.card4LinearLayout:
			if (card4IsHeld) {
				card4IsHeld = false;
				card4LinearLayout.setY(card4LinearLayout.getY() + 50);
			} else {
				card4IsHeld = true;
				card4LinearLayout.setY(card4LinearLayout.getY() - 50);
			}
			break;
		case R.id.card5LinearLayout:
			if (card5IsHeld) {
				card5IsHeld = false;
				card5LinearLayout.setY(card5LinearLayout.getY() + 50);
			} else {
				card5IsHeld = true;
				card5LinearLayout.setY(card5LinearLayout.getY() - 50);
			}
			break;

		default:
			break;
		}
	}

}
