package com.battlepoker_android.src;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

import com.example.battlepoker_android.R;

public class Map extends Activity implements OnClickListener {

	List<Level> levelList = new ArrayList<Level>();

	RelativeLayout layout;
	Player player;
	final int buttonSpacing = 275;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);

		layout = (RelativeLayout) findViewById(R.id.mapRelativeLayout);
		initializePlayer();
		initializeLevels();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void initializePlayer() {
		player = new Player();
		player.setHealth(100);
		player.setMana(100);
		//set the player's initial position to the first level in the list.  this will allow you to have starting levels at locations other than 0,0.

	}

	public void initializeLevels() {
		int idCounter = 0;
		levelList = new ArrayList<Level>();

		Resources res = getResources();

		//create an array for each attribute of the level
		TypedArray name = res.obtainTypedArray(R.array.Name);
		TypedArray health = res.obtainTypedArray(R.array.Health);
		TypedArray mana = res.obtainTypedArray(R.array.Mana);
		TypedArray xPosition = res.obtainTypedArray(R.array.xPosition);
		TypedArray yPosition = res.obtainTypedArray(R.array.yPosition);

		//loop through each array to create a new level object.  store the level in a list.
		for (int i = 0; i < name.length(); i++) {
			idCounter++;

			Level level = new Level(getApplicationContext());
			level.setImageResource(R.drawable.bad_guy_locked_1);

			level.setName(name.getString(i));
			level.setHealth(health.getInt(i, -1));
			level.setMana(mana.getInt(i, -1));
			level.setXPosition(xPosition.getInt(i, -1));
			level.setYPosition(yPosition.getInt(i, -1));
			level.setLevelState(Level.ENEMY_LOCKED);

			level.setOnClickListener(this);
			level.setId(idCounter);

			//positions the buttons and adds them to the layout.
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			layoutParams.leftMargin = (level.getXPosition() * buttonSpacing);
			layoutParams.topMargin = (level.getYPosition() * buttonSpacing);
			layout.addView(level, layoutParams);
			level.setClickable(false);
			levelList.add(level);
		}

		name.recycle();
		health.recycle();
		mana.recycle();
		xPosition.recycle();
		yPosition.recycle();

		player.setXPosition(levelList.get(0).getXPosition());
		player.setYPosition(levelList.get(0).getYPosition());

		updateButtons();
		updateButtonImages();

	}

	public void updateButton(Level level) {
		if (level.getLevelState() == Level.PLAYER_LOCATION) {
			level.setLevelState(Level.ENEMY_DEFEATED);
			level.setClickable(false);//change this later if we decide to allow you to look at defeated opponent stats or something.
		} else if (level.getXPosition() == player.getXPosition() && level.getYPosition() == player.getYPosition()) {
			level.setLevelState(Level.PLAYER_LOCATION);
			level.setClickable(false); //can change this later if we decide against it.
		} else if (Math.abs(level.getXPosition() - player.getXPosition()) <= 1 && level.getYPosition() == player.getYPosition()
				|| (Math.abs(level.getYPosition() - player.getYPosition()) <= 1 && level.getXPosition() == player.getXPosition())) {
			if (level.getLevelState() != Level.ENEMY_DEFEATED && level.getLevelState() != Level.PLAYER_LOCATION) {
				level.setLevelState(Level.ENEMY_UNLOCKED);
				level.setClickable(true);
			}
		}
		//the "ENEMY_DEFEATED" state should be updated somewhere else.  it will be done after the battle is over. 
	}

	//this version doesn't take in a level.  it loops through each level to set the button states.  should only be used for initialization
	public void updateButtons() {
		for (Level level : levelList) {
			updateButton(level); //avoids code duplication			
		}
	}

	public void updateButtonImage(Level level) {
		switch (level.getLevelState()) {
		case Level.PLAYER_LOCATION:
			level.setImageResource(R.drawable.player_1);
			break;
		case Level.ENEMY_LOCKED:
			level.setImageResource(R.drawable.bad_guy_locked_1);
			break;
		case Level.ENEMY_UNLOCKED:
			level.setImageResource(R.drawable.bad_guy_unlocked_1);
			break;
		case Level.ENEMY_DEFEATED:
			level.setImageResource(R.drawable.bad_guy_defeated_1);
			break;
		default:
			break;
		}
	}

	//this version doesn't take in a level.  it loops through each level to set the buttons.  should only be used for initialization
	public void updateButtonImages() { //i'm not sure why I have to pass levelList to this.  If I don't, levelList is 0;	
		for (Level level : levelList) {
			switch (level.getLevelState()) {
			case Level.PLAYER_LOCATION:
				level.setImageResource(R.drawable.player_1);
				break;
			case Level.ENEMY_LOCKED:
				level.setImageResource(R.drawable.bad_guy_locked_1);
				break;
			case Level.ENEMY_UNLOCKED:
				level.setImageResource(R.drawable.bad_guy_unlocked_1);
				break;
			case Level.ENEMY_DEFEATED:
				level.setImageResource(R.drawable.bad_guy_defeated_1);
				break;
			default:
				break;
			}
		}
	}

	public void onClick(View view) {

		for (int i = 0; i < levelList.size(); i++) {
			if (view.getId() == levelList.get(i).getId()) {
				//i'm setting the player location here for testing.  it will actually be done in the battle activity after the battle is successful.
				//here i'll do the checking.  if it's "rip", call "check bad guys' stats".  if it's "player" call "player" stats.  if it's "bad guy" call "battle."
				player.setXPosition(levelList.get(i).getXPosition());
				player.setYPosition(levelList.get(i).getYPosition());
				Intent newGameIntent = new Intent(Map.this, Battle.class);
				Map.this.startActivity(newGameIntent);
			}
			updateButton(levelList.get(i)); //just using this loop for multiple purposes.
			updateButtonImage(levelList.get(i));
		}

	}
}
