package com.battlepoker_android.src;

import com.example.battlepoker_android.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Battle extends Activity{
	//iterate through each level and update the level states
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_battle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
