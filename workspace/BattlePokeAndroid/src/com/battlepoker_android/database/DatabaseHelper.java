package com.battlepoker_android.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	private static final String databaseName = "gameDB";

	//game table
	private static final String GAMETABLE = "Game";
	private static final String GAMEID = "gameID";
	private static final String VERSION_NUMBER = "versionNumber";

	//player table
	private static final String PLAYER_TABLE = "Player";
	private static final String PLAYER_ID = "playerId"; //primary key
	private static final String PLAYER_NAME = "Name";
	private static final String PLAYER_HEALTH = "Health";
	private static final String PLAYER_MANA = "Mana";
	private static final String PLAYER_X_POSITION = "xPosition";
	private static final String PLAYER_Y_POSITION = "yPosition";
	private static final String PLAYER_ABILITY_LK = "abilityID";

	//ability table
	private static final String ABILITY_TABLE = "Ability";
	private static final String ABILITY_ID = "abilityID"; //primary key
	private static final String ABILITY_PLAYER_ID = "playerID"; //foreign key
	private static final String ABILITY_NAME = "Name";
	private static final String ABILITY_TYPE = "Type";

	//level table 
	private static final String LEVEL_TABLE = "Level";
	private static final String LEVEL_ID = "levelID"; //primary key
	private static final String LEVEL_PLAYER_ID = "playerID"; //foreign key
	private static final String LEVEL_X_POSITION = "xPosition";
	private static final String LEVEL_Y_POSITION = "yPosition";
	private static final String LEVEL_STATE = "status";

	//enemy table
	private static final String ENEMY_TABLE = "Enemy";
	private static final String ENEMY_ID = "enemyID"; //primary key
	private static final String ENEMY_PLAYER_ID = "levelID"; //foreign key
	private static final String ENEMY_NAME = "Name";
	private static final String ENEMY_HEALTH = "Health";
	private static final String ENEMY_MANA = "Mana";
	private static final String ENEMY_ABILITY_LK = "abilityID";

	public DatabaseHelper(Context context) {
		super(context, databaseName, null, 9);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + GAMETABLE + "(" + GAMEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VERSION_NUMBER + " INTEGER)");
		
		db.execSQL("CREATE TABLE " + PLAYER_TABLE + "(" + PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PLAYER_NAME + " TEXT," + PLAYER_HEALTH + " INTEGER," + PLAYER_MANA + " INTEGER,"
				+ PLAYER_X_POSITION + " INTEGER," + PLAYER_Y_POSITION + " INTEGER," + PLAYER_ABILITY_LK + " INTEGER)");
		
		db.execSQL("CREATE TABLE " + ABILITY_TABLE + "(" + ABILITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ABILITY_PLAYER_ID + " INTEGER," + ABILITY_NAME + " TEXT," + ABILITY_TYPE + " TEXT)");
		
		db.execSQL("CREATE TABLE " + LEVEL_TABLE + "(" + LEVEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LEVEL_PLAYER_ID + " INTEGER," + LEVEL_X_POSITION + " INTEGER," + LEVEL_Y_POSITION + " INTEGER,"
				+ LEVEL_STATE + " TEXT)");
		
		db.execSQL("CREATE TABLE " + ENEMY_TABLE + "(" + ENEMY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ENEMY_PLAYER_ID + " INTEGER," + ENEMY_NAME + " TEXT," + ENEMY_HEALTH + " INTEGER,"
				+ ENEMY_MANA + " INTEGER," + ENEMY_ABILITY_LK + " INTEGER)");

		//TODO: Insert dummy data for the first row of ever table.  that way we can do updates instead of inserts.
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
//		db.execSQL("DROP TABLE " + GAMETABLE);		
//		db.execSQL("DROP TABLE " + PLAYER_TABLE);
//		db.execSQL("DROP TABLE " + ABILITY_TABLE);
//		db.execSQL("DROP TABLE " + LEVEL_TABLE);
//		db.execSQL("DROP TABLE " + ENEMY_TABLE); 
		db.execSQL("CREATE TABLE " + GAMETABLE + "(" + GAMEID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + VERSION_NUMBER + " INTEGER)");
		
		db.execSQL("CREATE TABLE " + PLAYER_TABLE + "(" + PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + PLAYER_NAME + " TEXT," + PLAYER_HEALTH + " INTEGER," + PLAYER_MANA + " INTEGER,"
				+ PLAYER_X_POSITION + " INTEGER," + PLAYER_Y_POSITION + " INTEGER," + PLAYER_ABILITY_LK + " INTEGER)");
		
		db.execSQL("CREATE TABLE " + ABILITY_TABLE + "(" + ABILITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ABILITY_PLAYER_ID + " INTEGER," + ABILITY_NAME + " TEXT," + ABILITY_TYPE + " TEXT)");
		
		db.execSQL("CREATE TABLE " + LEVEL_TABLE + "(" + LEVEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LEVEL_PLAYER_ID + " INTEGER," + LEVEL_X_POSITION + " INTEGER," + LEVEL_Y_POSITION + " INTEGER,"
				+ LEVEL_STATE + " TEXT)");
		
		db.execSQL("CREATE TABLE " + ENEMY_TABLE + "(" + ENEMY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + ENEMY_PLAYER_ID + " INTEGER," + ENEMY_NAME + " TEXT," + ENEMY_HEALTH + " INTEGER,"
				+ ENEMY_MANA + " INTEGER," + ENEMY_ABILITY_LK + " INTEGER)");
	}


	public void saveGame(Game game){
		getPlayerTable();
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		
		//update player table
		//contentValues.put(PLAYER_ID, 1); // this should auto increment
		contentValues.put(PLAYER_NAME, game.getPlayer().getName());
		contentValues.put(PLAYER_HEALTH, game.getPlayer().getHealth());
		contentValues.put(PLAYER_MANA, game.getPlayer().getMana());
		contentValues.put(PLAYER_X_POSITION, game.getPlayer().getXPosition());
		contentValues.put(PLAYER_Y_POSITION, game.getPlayer().getYPosition());
		contentValues.put(PLAYER_ABILITY_LK, 0);
		
		db.insert(PLAYER_TABLE, PLAYER_ID, contentValues);
		contentValues.clear();
		
		//contentValues.put(ABILITY_ID, 1); // this should auto increment
		contentValues.put(ABILITY_PLAYER_ID, 1); // not sure about this
		contentValues.put(ABILITY_NAME, "Fire Ball");
		contentValues.put(ABILITY_TYPE, "Fire");
		//TODO
		//contentValues.put(PLAYER_ABILITY_LK, game.getPlayer().getName()); 
		db.insert(ABILITY_TABLE, ABILITY_ID, contentValues);
		//db.close();
		contentValues.clear();

		
		//contentValues.put(LEVEL_ID, 1); // this should auto increment
		contentValues.put(LEVEL_PLAYER_ID, 1); // not sure about this
		contentValues.put(LEVEL_X_POSITION, game.getLevel().getX());
		contentValues.put(LEVEL_Y_POSITION, game.getLevel().getY());
		contentValues.put(LEVEL_STATE, game.getLevel().getState());		
		//TODO
		//contentValues.put(PLAYER_ABILITY_LK, game.getPlayer().getName()); 
		db.insert(LEVEL_TABLE, LEVEL_ID, contentValues);
		//db.close();
		contentValues.clear();
				
		//contentValues.put(ENEMY_ID, 1);// this should auto increment
		contentValues.put(ENEMY_PLAYER_ID, 1); // not sure about this	
		contentValues.put(ENEMY_NAME, game.getEnemy().getName());
		contentValues.put(ENEMY_HEALTH, game.getEnemy().getHealth());
		contentValues.put(ENEMY_MANA, game.getEnemy().getMana());	
		contentValues.put(PLAYER_ABILITY_LK, 0); 
		
		db.insert(ENEMY_TABLE, ENEMY_ID, contentValues);
		contentValues.clear();
		db.close();
		getPlayerTable();
	}
	
//	public Cursor getGame(){
//		
//	}
	
	public Cursor getPlayerTable(){
		SQLiteDatabase db = this.getReadableDatabase();
		//String[] columns = new String[]{PLAYER_ID, PLAYER_NAME,PLAYER_HEALTH, PLAYER_MANA,PLAYER_X_POSTION, PLAYER_Y_POSTION, PLAYER_ABILITY_LK};
		Cursor cursor = db.rawQuery("SELECT * FROM " + PLAYER_TABLE, new String[]{});
		System.out.println("Column names = " + cursor.getColumnNames().toString());
		System.out.println("Row Count = " + cursor.getCount());
		
		return cursor;		
	}

}
