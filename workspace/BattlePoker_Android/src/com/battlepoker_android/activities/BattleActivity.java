package com.battlepoker_android.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.battlepoker_android.objects.*;
import com.example.battlepoker_android.R;

public class BattleActivity extends Activity {
	//layouts
	private ImageButton card1ImageButton;
	private ImageButton card2ImageButton;
	private ImageButton card3ImageButton;
	private ImageButton card4ImageButton;
	private ImageButton card5ImageButton;
	
	private TextView EnemyHealth;
	private Button DealButton;
	//this can be done better if each card is an object.
	private boolean card1IsHeld = false;
	private boolean card2IsHeld = false;
	private boolean card3IsHeld = false;
	private boolean card4IsHeld = false;
	private boolean card5IsHeld = false;
	
	private boolean dealtHand = false;

	//Create player that will be in the battle
	private Player player1 = new Player(100,100);
	private Deck deck = new Deck();
	//private boolean battleSuccessful = false;
	private Enemy enemy;

	//DealButton functionality
	public void Deal (View view){
		if(dealtHand == false){
			player1.hand [0] = deck.drawCard();
			player1.hand[1] = deck.drawCard();
			player1.hand [2] = deck.drawCard();
			player1.hand[3] = deck.drawCard();
			player1.hand [4] = deck.drawCard();
		}
		Bitmap bmCards = BitmapFactory.decodeResource(getResources(), R.drawable.deck_of_cards);
		bmCards = Bitmap.createScaledBitmap(bmCards, 1400, 580, false);
		
		if(card1IsHeld == false){
			if(dealtHand == true){
				player1.hand[0] = deck.drawCard();
			}
		card1ImageButton.setImageBitmap(Bitmap.createBitmap(bmCards, player1.hand[0].getX(), player1.hand[0].getY(), player1.hand[0].getWidth(), player1.hand[0].getHeight()));
		card1ImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		card1ImageButton.setPadding(0, 0, 0, 0);
		}
		
		if(card2IsHeld == false){
			if(dealtHand == true){
				player1.hand[1] = deck.drawCard();
			}
		card2ImageButton.setImageBitmap(Bitmap.createBitmap(bmCards, player1.hand[1].getX(), player1.hand[1].getY(), player1.hand[1].getWidth(), player1.hand[1].getHeight()));
		card2ImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		card2ImageButton.setPadding(0, 0, 0, 0);
		}
		
		if(card3IsHeld == false){
			if(dealtHand == true){
				player1.hand[2] = deck.drawCard();
			}
		card3ImageButton.setImageBitmap(Bitmap.createBitmap(bmCards, player1.hand[2].getX(), player1.hand[2].getY(), player1.hand[2].getWidth(), player1.hand[2].getHeight()));
		card3ImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		card3ImageButton.setPadding(0, 0, 0, 0);
		}
		
		if(card4IsHeld == false){
			if(dealtHand == true){
				player1.hand[3] = deck.drawCard();
			}
		card4ImageButton.setImageBitmap(Bitmap.createBitmap(bmCards, player1.hand[3].getX(), player1.hand[3].getY(), player1.hand[3].getWidth(), player1.hand[3].getHeight()));
		card4ImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		card4ImageButton.setPadding(0, 0, 0, 0);
		}
		if(card5IsHeld == false){
			if(dealtHand == true){
				player1.hand[4] = deck.drawCard();
			}
		card5ImageButton.setImageBitmap(Bitmap.createBitmap(bmCards, player1.hand[4].getX(), player1.hand[4].getY(), player1.hand[4].getWidth(), player1.hand[4].getHeight()));
		card5ImageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		card5ImageButton.setPadding(0, 0, 0, 0);
		}
		if(dealtHand==false){
			dealtHand = true;
			DealButton.setText("Draw");
		}
		else{
			String score = Integer.toString(Score.getScore(player1.hand));
			Context context = getApplicationContext();
			CharSequence text = score;
			int duration = Toast.LENGTH_LONG;
			
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			String eHealth = Integer.toString(Integer.parseInt((String) EnemyHealth.getText()) - Integer.parseInt(score));
			
			EnemyHealth.setText(eHealth);
			
			dealtHand = false;
			if(card1IsHeld == true){
			onClick(card1ImageButton);
			card1IsHeld = false;
			}
			if(card2IsHeld == true){			
			onClick(card2ImageButton);
			card2IsHeld = false;
			}
			if(card3IsHeld == true){
			onClick(card3ImageButton);
			card3IsHeld = false;
			}
			if(card4IsHeld == true){
			onClick(card4ImageButton);
			card4IsHeld = false;
			}
			if(card5IsHeld == true){
			onClick(card5ImageButton);
			card5IsHeld = false;
			}
					
			dealtHand = false;
			DealButton.setText("Deal");
		}
	}
	
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
		EnemyHealth = (TextView) findViewById(R.id.EnemyHealth);
		DealButton = (Button) findViewById(R.id.DealButton);
		
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
