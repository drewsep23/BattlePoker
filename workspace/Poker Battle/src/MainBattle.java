
public class MainBattle {

	
	public static void main(String[] args) {
		Deck myDeck = new Deck();
		Player player1 = new Player();
		Player player2 = new Player();
		player1.hand[0] = myDeck.drawCard();
		player1.hand[1] = myDeck.drawCard();
		player1.hand[2] = myDeck.drawCard();
		player1.hand[3] = myDeck.drawCard();
		player1.hand[4] = myDeck.drawCard();
		
		player2.hand[0] = "5c";
		player2.hand[1] = "6d";
		player2.hand[2] = "6d";
		player2.hand[3] = "5c";
		player2.hand[4] = "5s";
		
		for(int i = 0;i<5;i++){
		System.out.print("["+player2.hand[i]+"] ");
		}
		
		System.out.println(Score.getScore(player2.hand));
	}

}
