package com.battlepoker_android.database;

import com.battlepoker_android.objects.Enemy;
import com.battlepoker_android.objects.Level;
import com.battlepoker_android.objects.Player;

public class Game {
	private Player player;
	private Enemy enemy;
	private Level level;
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Enemy getEnemy() {
		return enemy;
	}
	public void setEnemy(Enemy enemy) {
		this.enemy = enemy;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}

}
