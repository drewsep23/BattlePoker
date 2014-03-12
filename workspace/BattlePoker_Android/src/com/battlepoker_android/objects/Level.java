package com.battlepoker_android.objects;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class Level extends ImageButton {

	private int x, y;
	private int state;
	private Enemy enemy = new Enemy();
	//	private Player player = new Player();

	public final static int PLAYER_LOCATION = 1;
	public final static int ENEMY_LOCKED = 2;
	public final static int ENEMY_UNLOCKED = 3;
	public final static int ENEMY_DEFEATED = 4;

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

	public Enemy getEnemy() {
		return enemy;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
}
