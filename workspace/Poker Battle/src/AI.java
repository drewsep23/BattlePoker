import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class AI {
	
	public String fourSuit(String [] nHand){
		int dnum=0,cnum=0,snum=0,hnum=0;
		for(int i = 0;i<=4;i++){
			if(nHand[i].substring(1).equals("d")){
				dnum++;
			}
			if(nHand[i].substring(1).equals("s")){
				snum++;
			}
			if(nHand[i].substring(1).equals("h")){
				hnum++;
			}
			if(nHand[i].substring(1).equals("c")){
				cnum++;
			}
		}
		if(dnum==4){
			return "d";
		}
		if(snum==4){
			return "s";
		}
		if(hnum==4){
			return "h";
		}
		if(cnum==4){
			return "c";
		}
		return "no";
	}
	
	public String [] makeDecision(String [] comHand){
		String [] aHand = new String [5];
		int aScore;
		aScore = Score.getScore(comHand);
		
		//If player has a good hand with no need to draw new cards then return hand
		if(aScore>=40){
			return comHand;
		}
		
		//If player has pair or three of a kind then draw cards that are not that match
		if(aScore==30||aScore==10||aScore==15){
			int next = 0;
			String pair;
			for(int i = 0;i<4;i++){
				next++;
				for(int j = next;j<5;j++){
					if(comHand[i].substring(0,1).equals(comHand[j].substring(0,1))){
						pair = comHand[i].substring(0,1);
						for(int g = 0;g<=4;g++){
							if(!comHand[g].substring(0,1).equals(pair)){
								comHand[g] = "draw";
							}
						}
						return comHand;
					}
				}
			}
		}
		//********************************************************************************
		
		//if two pairs then draw odd card out
		if(aScore==20){
		
			String first=null,second=null,third=null;
			String aChange=null;
			int count1=0,count2=0,count3=0;
			first = comHand[0].substring(0,1);
			for(int g = 1;g<=4;g++){
				if(!first.equals(comHand[g].substring(0,1))){
					second = comHand[g].substring(0,1);
					for(int i = g+1;i<=4;i++){
						if(!first.equals(comHand[i].substring(01))&&!second.equals(comHand[i].substring(0,1))){
							third = comHand[i].substring(0,1);
							i=5;
							g=5;
						}
					}
				}
			}
			
			for(int k = 0; k<=4;k++){
				if(first.equals(comHand[k].substring(0,1))){
					count1++;
				}
				if(second.equals(comHand[k].substring(0,1))){
					count2++;
				}
				if(third.equals(comHand[k].substring(0,1))){
					count3++;
				}
			}
			if(count1==1){
				aChange = first;
			}
			if(count2==1){
				aChange = second;
			}
			if(count3==1){
				aChange = third;
			}
			for(int h = 0;h<=4;h++){
				if(aChange.equals(comHand[h].substring(0,1))){
					comHand[h]="draw";
					h=5;
				}
			}
			return comHand;
		}
		
		//********************************************************************************
		
		//Change single card that does not match suit in order to go for flush
		String Suits = fourSuit(comHand);
		if(!Suits.equals("no")){
			if(Suits.equals("d")){
				for(int i = 0;i<=4;i++){
					if(!comHand[i].substring(1).equals("d")){
						comHand[i] = "draw";
						return comHand;
					}
				}
			}
			if(Suits.equals("s")){
				for(int i = 0;i<=4;i++){
					if(!comHand[i].substring(1).equals("s")){
						comHand[i] = "draw";
						return comHand;
					}
				}
			}
			if(Suits.equals("c")){
				for(int i = 0;i<=4;i++){
					if(!comHand[i].substring(1).equals("c")){
						comHand[i] = "draw";
						return comHand;
					}
				}
			}
			if(Suits.equals("h")){
				for(int i = 0;i<=4;i++){
					if(!comHand[i].substring(1).equals("h")){
						comHand[i] = "draw";
						return comHand;
					}
				}
			}
		}
		//**************************************************************
		
		int change=69;
		String aChange;
		
		//Check for 4 in a row to draw a card for a straight
		int [] straightHand = new int [5];
		for(int i = 0;i<=4;i++){
			
			straightHand [i] = Integer.parseInt(comHand[i].substring(0,1));
			
			if(comHand[i].substring(0,1)=="J"){
				straightHand [i] = 11;
			}
			if(comHand[i].substring(0,1)=="Q"){
				straightHand [i] = 12;
			}
			if(comHand[i].substring(0,1)=="K"){
				straightHand [i] = 13;
			}
			if(comHand[i].substring(0,1)=="A"){
				straightHand [i] = 14;
			}
			if(comHand[i].substring(0,1)=="1"){
				straightHand [i] = 10;
			}
		}
		List<Integer> listHand = new ArrayList<Integer>();
		for(int i = 0;i<=4;i++){
			listHand.add(straightHand[i]);
		}
		//changes the ace to a 1 value if low straight
		if(listHand.contains(14)&&listHand.contains(2)&&listHand.contains(3)){
			listHand.remove(14);
			listHand.add(1);
		}
		Collections.sort(listHand);
		if(listHand.indexOf(1)-listHand.indexOf(0)==1 && listHand.indexOf(2)-listHand.indexOf(1)==1 && listHand.indexOf(3)-listHand.indexOf(2)==1){
			change = listHand.indexOf(4);
		}
		if(listHand.indexOf(4)-listHand.indexOf(3)==1 && listHand.indexOf(3)-listHand.indexOf(2)==1 && listHand.indexOf(2)-listHand.indexOf(1)==1){
			change = listHand.indexOf(0);
		}
		aChange = Integer.toString(change);
		if(change == 10){
			aChange = "1";
		}
		if(change == 11){
			aChange = "J";
		}
		if(change == 12){
			aChange = "Q";
		}
		if(change == 13){
			aChange = "K";
		}
		if(change == 14 || change == 1){
			aChange = "A";
		}
		aChange = Integer.toString(change);
		if(change!=69){
			for(int j=0;j<=4;j++){
				if(comHand[j].substring(0,1)==aChange){
					comHand[j]="draw";
					return comHand;
				}
			}
		}
		//****************************************************
		
		//Draw a whole new hand
		for(int i = 0;i<=4;i++){
			if(!comHand[i].substring(0,1).equals("J")&&!comHand[i].substring(0,1).equals("Q")&&!comHand[i].substring(0,1).equals("K")&&!comHand[i].substring(0,1).equals("A"))
			comHand[i]="draw";
		}
		return comHand;
	}
}
