import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Score {
	
	private static boolean isFlush(String [] myHand){
		for(int i=1;i<4;i++){
		if(myHand[0].charAt(1)!=(myHand[i].charAt(1))){
			return false;
		}
		}
		return true;
	}
	
	private static boolean isStraight(String [] myHand){
		String [] swapHand = new String [5];
		swapHand[0] = myHand[0];
		swapHand[1] = myHand[1];
		swapHand[2] = myHand[2];
		swapHand[3] = myHand[3];
		swapHand[4] = myHand[4];
		
		for(int i=0;i<5;i++){
			swapHand[i] = swapHand[i].substring(0,1);
		}
		
		List<String> aHand = new ArrayList<String>(Arrays.asList(swapHand)); 
		if(aHand.contains("A")&& aHand.contains("2") && aHand.contains("3") && aHand.contains("4")&& aHand.contains("5")){
			return true;
		}
		if(aHand.contains("6")&& aHand.contains("2") && aHand.contains("3") && aHand.contains("4")&& aHand.contains("5")){
			return true;
		}
		if(aHand.contains("6")&& aHand.contains("7") && aHand.contains("3") && aHand.contains("4")&& aHand.contains("5")){
			return true;
		}
		if(aHand.contains("6")&& aHand.contains("7") && aHand.contains("8") && aHand.contains("4")&& aHand.contains("5")){
			return true;
		}
		if(aHand.contains("6")&& aHand.contains("7") && aHand.contains("8") && aHand.contains("9")&& aHand.contains("5")){
			return true;
		}
		if(aHand.contains("6")&& aHand.contains("7") && aHand.contains("8") && aHand.contains("9")&& aHand.contains("1")){
			return true;
		}
		if(aHand.contains("J")&& aHand.contains("7") && aHand.contains("8") && aHand.contains("9")&& aHand.contains("1")){
			return true;
		}
		if(aHand.contains("J")&& aHand.contains("Q") && aHand.contains("8") && aHand.contains("9")&& aHand.contains("1")){
			return true;
		}
		if(aHand.contains("J")&& aHand.contains("Q") && aHand.contains("K") && aHand.contains("9")&& aHand.contains("1")){
			return true;
		}
		if(aHand.contains("J")&& aHand.contains("Q") && aHand.contains("K") && aHand.contains("A")&& aHand.contains("1")){
			return true;
		}
		return false;
	}
	
	private static boolean isPair(String [] myHand){
		int next = 0;
		for(int i = 0;i<3;i++){
			next++;
			for(int j = next;j<4;j++){
				if(myHand[i].substring(0,1).equals(myHand[j].substring(0,1))){
					return true;
				}
			}
		}
		return false;
	}
	
	//Two pair will return true if FullHouse is present
	private static boolean isTwoPair(String [] myHand){
		int next = 0;
		for(int i = 0;i<=3;i++){
			next++;
			for(int j = next;j<=4;j++){
				if(myHand[i].substring(0,1).equals(myHand[j].substring(0,1))){
					List<String> aHand = new ArrayList<String>(Arrays.asList(myHand));
					aHand.remove(i);
					aHand.remove(j-1);
					if(aHand.get(0).substring(0,1).equals(aHand.get(1).substring(0,1))||aHand.get(0).substring(0,1).equals(aHand.get(2).substring(0,1))||aHand.get(1).substring(0,1).equals(aHand.get(2).substring(0,1))){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	private static boolean isThreeOfKind(String [] myHand){
		int next = 0;
		for(int i = 0;i<3;i++){
			next++;
			for(int j = next;j<4;j++){
				if(myHand[i].substring(0,1).equals(myHand[j].substring(0,1))){
					if(j<4){
						int g = j+1;
						while(g<=4){
							if(myHand[j].substring(0,1).equals(myHand[g].substring(0,1))){
								return true;
							}
							g++;
						}
					}
				}
			}
		}
		return false;
	}
	
	
	private static boolean isFourOfKind(String [] myHand){
		int next = 0;
		for(int i = 0;i<4;i++){
			next++;
			for(int j = next;j<5;j++){
				if(myHand[i].substring(0,1).equals(myHand[j].substring(0,1))){
					if(j<4){
						int g = j+1;
						while(g<=4){
							if(myHand[j].substring(0,1).equals(myHand[g].substring(0,1))){
								if(g<4){
									int k = g+1;
									while(k<=4){
										if(myHand[g].substring(0,1).equals(myHand[k].substring(0,1))){
											return true;
										}
										k++;
									}
								}
							}
							g++;
						}
					}
				}
			}
		}
		return false;
	}

	
	private static boolean isFullHouse(String [] myHand){
		String card1="j",card2="j";
		for(int i = 0;i<4;i++){
			for(int g = 1; g<5;g++){
				if(!myHand[i].substring(0,1).equals(myHand[g].substring(0,1))){
					card1=myHand[i].substring(0,1);
					card2=myHand[g].substring(0,1);
				}
			}
		}
		for(int k = 0;k<4;k++){
			if(!myHand[k].substring(0,1).equals(card1) && !myHand[k].substring(0,1).equals(card2)){
				return false;
			}
		}
		return true;
	}
	
	public static String getScore(String [] aHand){
		if(isFlush(aHand)&&isStraight(aHand)){
			return "Straight Flush!";
		}
		if(isFourOfKind(aHand)){
			return "Four Of A Kind!";
		}
		if(isFullHouse(aHand)){
			return "Full House!";
		}
		if(isFlush(aHand)){
			return "Flush!";
		}
		if(isStraight(aHand)){
			return "Straight!";
		}
		if(isThreeOfKind(aHand)){
			return "Three Of Kind!";
		}
		if(isTwoPair(aHand)){
			return "Two Pairs!";
		}
		if(isPair(aHand)){
			return "Pair!";
		}
		return "Sorry Nothing";
		
	}

}
