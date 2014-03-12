//package com.battlepoker_android.utilities;
//
//import android.app.Activity;
//import android.graphics.Point;
//import android.view.Display;
//
//public class UsefulMethods extends Activity {
//
//	private Display display;
//	private Point size;
//	private int width;
//	private int height;
//
//	public void getDimensions() {
//		display = getWindowManager().getDefaultDisplay();
//		size = new Point();
//		display.getSize(size);//this causes us to use api level 13.  There are other methods of doing this if we need to target a lower api.
//		width = size.x;
//		height = size.y;
//	}
//
//	public Point getSize() {
//		return size;
//	}
//
//	public int getWidth() {
//		return width;
//	}
//
//	public int getHeight() {
//		return height;
//	}
//
//}
