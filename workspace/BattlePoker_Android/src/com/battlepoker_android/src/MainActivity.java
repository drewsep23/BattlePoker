package com.battlepoker_android.src;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.battlepoker_android.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.newGameButton:
			Intent newGameIntent = new Intent(MainActivity.this, Map.class);
			MainActivity.this.startActivity(newGameIntent);
			break;
		case R.id.loadGameButton:
			// putExtra....
			// Intent i = new Intent(MainActivity.this,adminhome.class);
			// MainActivity.this.startActivity(i);
			break;
		case R.id.optionsButton:

			break;

		default:
			break;
		}
	}
}
