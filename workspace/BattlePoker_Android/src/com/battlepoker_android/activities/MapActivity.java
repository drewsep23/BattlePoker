package com.battlepoker_android.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;

import com.battlepoker_android.database.DatabaseHelper;
import com.battlepoker_android.database.Game;
import com.battlepoker_android.objects.Level;
import com.battlepoker_android.objects.Player;
import com.example.battlepoker_android.R;

public class MapActivity extends Activity implements OnClickListener {

	private List<Level> levelList = new ArrayList<Level>();

	private RelativeLayout layout;
	private int buttonSpacing;
	private Display display;
	private Point size;
	private int width;
	private int height;
	private Player player;
	private Game game;
	private DatabaseHelper db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_map);

		layout = (RelativeLayout) findViewById(R.id.mapRelativeLayout);
		game = new Game();
		player = new Player(100, 100);
		db = new DatabaseHelper(getApplicationContext());
		setButtonSpacing();
		initializeLevels();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.		
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	//we can put this in a utility class later if we use it alot.
	private void setButtonSpacing() {
		display = getWindowManager().getDefaultDisplay();
		size = new Point();
		display.getSize(size);//this causes us to use api level 13.  There are other methods of doing this if we need to target a lower api.
		width = size.x;
		height = size.y;
		buttonSpacing = height / 4;
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

			level.getEnemy().setName(name.getString(i));
			level.getEnemy().setHealth(health.getInt(i, -1));
			level.getEnemy().setMana(mana.getInt(i, -1));
			level.setXPosition(xPosition.getInt(i, -1));
			level.setYPosition(yPosition.getInt(i, -1));
			level.setState(Level.ENEMY_LOCKED);

			level.setOnClickListener(this);
			level.setId(idCounter);

			//positions the buttons and adds them to the layout.
			RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
			//			layoutParams.width = 200;
			//			layoutParams.height = 200;
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

	//this is static so that the battle activity can update the level states.
	public void updateButton(Level level) {
		if (level.getState() == Level.PLAYER_LOCATION) {
			level.setState(Level.ENEMY_DEFEATED);
			level.setClickable(false);//change this later if we decide to allow you to look at defeated opponent stats or something.
		} else if (level.getXPosition() == player.getXPosition() && level.getYPosition() == player.getYPosition()) {
			level.setState(Level.PLAYER_LOCATION);
			level.setClickable(false); //can change this later if we decide against it.
		} else if (Math.abs(level.getXPosition() - player.getXPosition()) <= 1 && level.getYPosition() == player.getYPosition()
				|| (Math.abs(level.getYPosition() - player.getYPosition()) <= 1 && level.getXPosition() == player.getXPosition())) {
			if (level.getState() != Level.ENEMY_DEFEATED && level.getState() != Level.PLAYER_LOCATION) {
				level.setState(Level.ENEMY_UNLOCKED);
				level.setClickable(true);
			}
		}
		//the "ENEMY_DEFEATED" state should be updated somewhere else.  it will be done after the battle is over. 
	}

	//this version doesn't take in a level.  it loops through each level to set the button states.  should only be used for initialization
	public void updateButtons() {
		for (Level level : levelList) {
			updateButton(level);
		}
	}

	public void updateButtonImage(Level level) {
		switch (level.getState()) {
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
	public void updateButtonImages() {
		for (Level level : levelList) {
			switch (level.getState()) {
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

	@Override
	public void onClick(View view) {

		for (int i = 0; i < levelList.size(); i++) {
			if (view.getId() == levelList.get(i).getId()) {
				//i'm setting the player location here for testing.  it will actually be done in the battle activity after the battle is successful.
				//here i'll do the checking.  if it's "rip", call "check bad guys' stats".  if it's "player" call "player" stats.  if it's "bad guy" call "battle."
				//levelList.get(i).getPlayer().setXPosition(levelList.get(i).getXPosition());
				//levelList.get(i).getPlayer().setYPosition(levelList.get(i).getYPosition());
				//we need to pass the level to the battle activity so that we can get the player and enemy objects.
				player.setXPosition(levelList.get(i).getXPosition());
				player.setYPosition(levelList.get(i).getYPosition());
				//save game information before going to battle
				game.setPlayer(player);
				game.setLevel(levelList.get(i));
				game.setEnemy(levelList.get(i).getEnemy());	//not sure what to do with this.....		
				db.saveGame(game);
				//pass information to the battle
				Intent newIntent = new Intent(getBaseContext(), BattleActivity.class);
				newIntent.putExtra("com.battlepoker_android.objects.Enemy", levelList.get(i).getEnemy());
				MapActivity.this.startActivity(newIntent);
			}
			updateButton(levelList.get(i)); //just using this loop for multiple purposes.
			updateButtonImage(levelList.get(i));
		}

	}
}
