package com.battlepoker_android.src;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class Level extends ImageButton {
	private int x, y;
	private int health;
	private int mana;
	private String name;
	private int levelState;

	final static int PLAYER_LOCATION = 1;
	final static int ENEMY_LOCKED = 2;
	final static int ENEMY_UNLOCKED = 3;
	final static int ENEMY_DEFEATED = 4;

	public Level(Context context) {
		super(context);
	}

	public Level(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public Level(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public int getXPosition() {
		return x;
	}

	public void setXPosition(int x) {
		this.x = x;
	}

	public int getYPosition() {
		return y;
	}

	public void setYPosition(int y) {
		this.y = y;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevelState() {
		return levelState;
	}

	public void setLevelState(int levelState) {
		this.levelState = levelState;
	}
}
