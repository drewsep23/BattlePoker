package com.battlepoker_android.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
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
	
	private ImageButton [] cardImageButton = new ImageButton [5];
	private ImageButton [] enemyCardImageButton = new ImageButton [5];
	
	private ImageView enemyImageView;
	private ImageView playerImageView;
	
	private TextView EnemyHealth;
	private TextView PlayerHealth;
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
	private Player enemy1;
	private Enemy enemy = new Enemy();

	
	
	//DealButton functionality
	public void Deal (View view){
		if(dealtHand == false){
			deck = new Deck();
			player1.hand = newHand();
			enemy1.hand = newHand();
		}
		
		setPlayerCards();
		setEnemyCards();
		
		if(dealtHand==false){
			dealtHand = true;
			DealButton.setText("Draw");
			enemy1.hand = AI.makeDecision(enemy1.hand);
			for(int i = 0 ; i<=4; i++){
				if(enemy1.hand[i].isHeld()){
					enemyCardImageButton[i].setY(enemyCardImageButton[i].getY() + 25);
				}
			}
		}
		else{
			String score = Integer.toString(Score.getScore(player1.hand));
			Context context = getApplicationContext();
			CharSequence text = "You Attack: "+Score.getHandValue(Integer.parseInt(score))+" " + score;
			int duration = Toast.LENGTH_LONG;
			
			
			////////////Toast
			Runnable runnable = new Runnable(){
			public void run(){
				playerImageView.animate().rotation(0);
				playerImageView.animate().x(0).y(0);
			}
			};
			playerImageView.animate().withEndAction(runnable);
			playerImageView.animate().setDuration(1000);
			playerImageView.animate().x(100).y(0);
			playerImageView.animate().rotation(30);


			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			String eHealth = Integer.toString(Integer.parseInt((String) EnemyHealth.getText()) - Integer.parseInt(score));
			
			String enemyScore = Integer.toString(Score.getScore(enemy1.hand));
			Context context1 = getApplicationContext();
			CharSequence text1 = "Enemy Attacks: "+Score.getHandValue(Integer.parseInt(enemyScore))+" " + enemyScore;
			int duration1 = Toast.LENGTH_LONG;
			
			Runnable runnable1 = new Runnable(){
			public void run(){
				enemyImageView.animate().rotation(0);
				enemyImageView.animate().x(enemyImageView.getX()+100).y(enemyImageView.getY());
			}
			};
			enemyImageView.animate().withEndAction(runnable1);
			enemyImageView.animate().setDuration(1000);
			enemyImageView.animate().x(enemyImageView.getX()-100).y(enemyImageView.getY());
			enemyImageView.animate().rotation(30);
			
			Toast toast1 = Toast.makeText(context1, text1, duration1);
			toast1.setGravity(Gravity.CENTER, 0, 0);
			toast1.show();
			String pHealth = Integer.toString(Integer.parseInt((String) PlayerHealth.getText()) - Integer.parseInt(enemyScore));
			/////////////////
			
			EnemyHealth.setText(eHealth);
			PlayerHealth.setText(pHealth);
			
			
			dealtHand = false;
			if(card1IsHeld == true){
			onClick(cardImageButton[0]);
			card1IsHeld = false;
			}
			if(card2IsHeld == true){			
			onClick(cardImageButton[1]);
			card2IsHeld = false;
			}
			if(card3IsHeld == true){
			onClick(cardImageButton[2]);
			card3IsHeld = false;
			}
			if(card4IsHeld == true){
			onClick(cardImageButton[3]);
			card4IsHeld = false;
			}
			if(card5IsHeld == true){
			onClick(cardImageButton[4]);
			card5IsHeld = false;
			}
			
			for(int i = 0 ; i<=4;i++){
			if(enemy1.hand[i].isHeld()){
				enemyCardImageButton[i].setY(enemyCardImageButton[i].getY() - 25);
				enemy1.hand[i].setHeld(false);
			}
			}
			
					
			dealtHand = false;
			DealButton.setText("Deal");
			
		}
	}
	
	public Card[] newHand(){
		Card[] newCards = new Card [5];
		for(int i =0; i<=4;i++){
			newCards[i] = deck.drawCard();
		}
		return newCards;
	}
	
	public void setPlayerCards(){
		
		Bitmap bmCards = BitmapFactory.decodeResource(getResources(), R.drawable.deck_of_cards);
		bmCards = Bitmap.createScaledBitmap(bmCards, 1400, 580, false);
		
		for(int i =0; i<=4;i++){
			if(!player1.hand[i].isHeld()){
				if(dealtHand == true){
					player1.hand[i] = deck.drawCard();
				}
				cardImageButton[i].setImageBitmap(Bitmap.createBitmap(bmCards, player1.hand[i].getX(), player1.hand[i].getY(), player1.hand[i].getWidth(), player1.hand[i].getHeight()));
				cardImageButton[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
				cardImageButton[i].setPadding(0, 0, 0, 0);
	
			}
		}
	}

	public void setEnemyCards(){
		
		Bitmap bmCards = BitmapFactory.decodeResource(getResources(), R.drawable.deck_of_cards);
		bmCards = Bitmap.createScaledBitmap(bmCards, 1400, 580, false);
		
		for(int i =0; i<=4;i++){
			if(!enemy1.hand[i].isHeld()){
				if(dealtHand == true){
					enemy1.hand[i] = deck.drawCard();
				}
				enemyCardImageButton[i].setImageBitmap(Bitmap.createBitmap(bmCards, enemy1.hand[i].getX(), enemy1.hand[i].getY(), enemy1.hand[i].getWidth(), enemy1.hand[i].getHeight()));
				enemyCardImageButton[i].setScaleType(ImageView.ScaleType.FIT_CENTER);
				enemyCardImageButton[i].setPadding(0, 0, 0, 0);
	
			}
		}
	}
	
	//iterate through each level and update the level states
	@Override
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);;
		setContentView(R.layout.activity_battle);
		enemy = (Enemy) getIntent().getSerializableExtra("com.battlepoker_android.objects.Enemy");
		enemy1 = new Player(enemy.getHealth(),enemy.getMana());
		
		enemyImageView = (ImageView) findViewById(R.id.battle_bowser);
		playerImageView = (ImageView) findViewById(R.id.battle_mario_image);
		
		cardImageButton[0] = (ImageButton) findViewById(R.id.card1ImageButton);
		cardImageButton[1] = (ImageButton) findViewById(R.id.card2ImageButton);
		cardImageButton[2] = (ImageButton) findViewById(R.id.card3ImageButton);
		cardImageButton[3] = (ImageButton) findViewById(R.id.card4ImageButton);
		cardImageButton[4] = (ImageButton) findViewById(R.id.card5ImageButton);
		
		enemyCardImageButton[0] = (ImageButton) findViewById(R.id.EnemyCard1Image);
		enemyCardImageButton[1] = (ImageButton) findViewById(R.id.EnemyCard2Image);
		enemyCardImageButton[2] = (ImageButton) findViewById(R.id.EnemyCard3Image);
		enemyCardImageButton[3] = (ImageButton) findViewById(R.id.EnemyCard4Image);
		enemyCardImageButton[4] = (ImageButton) findViewById(R.id.EnemyCard5Image);

		
		EnemyHealth = (TextView) findViewById(R.id.EnemyHealth);
		PlayerHealth = (TextView) findViewById(R.id.PlayerHealth);
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
				player1.hand[0].setHeld(false);
				cardImageButton[0].setY(cardImageButton[0].getY() + 50);//change to non-hardcoded value.
			} else {
				card1IsHeld = true;
				player1.hand[0].setHeld(true);
				cardImageButton[0].setY(cardImageButton[0].getY() - 50);
			}
			break;
		case R.id.card2ImageButton:
			if (card2IsHeld) {
				card2IsHeld = false;
				player1.hand[1].setHeld(false);
				cardImageButton[1].setY(cardImageButton[1].getY() + 50);
			} else {
				card2IsHeld = true;
				player1.hand[1].setHeld(true);
				cardImageButton[1].setY(cardImageButton[1].getY() - 50);
			}
			break;
		case R.id.card3ImageButton:
			if (card3IsHeld) {
				card3IsHeld = false;
				player1.hand[2].setHeld(false);
				cardImageButton[2].setY(cardImageButton[2].getY() + 50);
			} else {
				card3IsHeld = true;
				player1.hand[2].setHeld(true);
				cardImageButton[2].setY(cardImageButton[2].getY() - 50);
			}
			break;
		case R.id.card4ImageButton:
			if (card4IsHeld) {
				card4IsHeld = false;
				player1.hand[3].setHeld(false);
				cardImageButton[3].setY(cardImageButton[3].getY() + 50);
			} else {
				card4IsHeld = true;
				player1.hand[3].setHeld(true);
				cardImageButton[3].setY(cardImageButton[3].getY() - 50);
			}
			break;
		case R.id.card5ImageButton:
			if (card5IsHeld) {
				card5IsHeld = false;
				player1.hand[4].setHeld(false);
				cardImageButton[4].setY(cardImageButton[4].getY() + 50);
			} else {
				card5IsHeld = true;
				player1.hand[4].setHeld(true);
				cardImageButton[4].setY(cardImageButton[4].getY() - 50);
			}
			break;
			
			//Enemy Card Set
			
		case R.id.EnemyCard1Image:
			if (enemy.hand[0].isHeld()) {
				enemy.hand[0].setHeld(false);
				enemyCardImageButton[0].setY(enemyCardImageButton[0].getY() - 25);

			} else {
				player1.hand[0].setHeld(true);
				enemyCardImageButton[0].setY(enemyCardImageButton[0].getY() + 25);

			}
			break;
		case R.id.EnemyCard2Image:
			if (enemy.hand[1].isHeld()) {
				enemy.hand[1].setHeld(false);
				enemyCardImageButton[1].setY(enemyCardImageButton[1].getY() - 25);

			} else {
				enemy.hand[1].setHeld(true);
				enemyCardImageButton[1].setY(enemyCardImageButton[1].getY() + 25);

			}
			break;
		case R.id.EnemyCard3Image:
			if (enemy.hand[2].isHeld()) {
				enemy.hand[2].setHeld(false);
				enemyCardImageButton[2].setY(enemyCardImageButton[2].getY() - 25);

			} else {
				enemy.hand[2].setHeld(true);
				enemyCardImageButton[2].setY(enemyCardImageButton[2].getY() + 25);

			}
			break;
		case R.id.EnemyCard4Image:
			if (enemy.hand[3].isHeld()) {
				enemy.hand[3].setHeld(false);
				enemyCardImageButton[3].setY(enemyCardImageButton[3].getY() - 25);

			} else {
				enemy.hand[3].setHeld(true);
				enemyCardImageButton[3].setY(enemyCardImageButton[3].getY() + 25);

			}
			break;
		case R.id.EnemyCard5Image:
			if (enemy.hand[4].isHeld()) {
				enemy.hand[4].setHeld(false);
				enemyCardImageButton[4].setY(enemyCardImageButton[4].getY() - 25);

			} else {
				enemy.hand[4].setHeld(true);
				enemyCardImageButton[4].setY(enemyCardImageButton[4].getY() + 25);

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
