//package com.battlepoker_android.src;
//
//import com.example.battlepoker_android.R;
//
//import android.content.Context;
//import android.util.AttributeSet;
//import android.widget.ImageButton;
//
//public class CustomImageButton extends ImageButton {
//	
//	//might not need any customimagebutton.  I can probably make ImageButton work just fine.
//	private State state; 
//	private int image;
//	
//	public CustomImageButton(Context context) {
//		super(context);
//		state = State.YOUR_LOCATION;
//
//	}
//
//	public CustomImageButton(Context context, AttributeSet attrs) {
//		super(context, attrs);
//		state = State.YOUR_LOCATION;
//	}
//
//	public CustomImageButton(Context context, AttributeSet attrs, int defStyle) {
//		super(context, attrs, defStyle);
//		state = State.YOUR_LOCATION;
//	}
//	
//	public State getState(){
//		return state;		
//	}
//	
//	public void setState(State state){
//		this.state = state;
//	}
//	
//	public int getImage(){
//		System.out.println("State = " + state);
//		switch (state) {		
//		case OPPONENT_ACTIVE:
//			image = R.drawable.bad_guy_unlocked_1;
//			break;
//		case OPPONENT_INACTIVE:
//			image = R.drawable.bad_guy_locked_1;
//			break;
//		case OPPONENT_DEAD:
//			image = R.drawable.bad_guy_defeated_1;
//			break;
//		case YOUR_LOCATION:
//			image = R.drawable.player_1;
//			break;
//		default:
//			break;
//		}
//		return image;
//	}
	

//}
