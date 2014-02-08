
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
		
		player2.hand[0] = "1c";
		player2.hand[1] = "Jc";
		player2.hand[2] = "Qc";
		player2.hand[3] = "Kc";
		player2.hand[4] = "Ac";
		for(int i = 0;i<5;i++){
		System.out.print("["+player2.hand[i]+"] ");
		}
		
		
		System.out.print(Score.getScore(player2.hand));
		
	}

}
