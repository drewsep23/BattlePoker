import java.io.*;

public class MainBattle {

	
	public static void main(String[] args) {
		BufferedReader fin= new BufferedReader(new InputStreamReader(System.in));
		String quitGame = "no";
		Player player1 = new Player();
		while(!quitGame.equals("quit")){
		Deck myDeck = new Deck();
		Player player2 = new Player();
		player1.hand[0] = myDeck.drawCard();
		player1.hand[1] = myDeck.drawCard();
		player1.hand[2] = myDeck.drawCard();
		player1.hand[3] = myDeck.drawCard();
		player1.hand[4] = myDeck.drawCard();
		
		int aScore;
		
		player1.health -= 10;
		
		for(int i = 0;i<5;i++){
		System.out.print("["+player1.hand[i]+"] ");
		}
		System.out.println("\n"+" 1    2    3    4    5");
		System.out.println("Select which cards you would like to change. Type 'done' when finished");
		int holdCard;
		String finished="none";
		while(!finished.equals("done")){
			try {
				finished = fin.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!finished.equals("done")&&!finished.equals("quit")){
				holdCard = Integer.parseInt(finished);
				player1.hand[holdCard-1] = myDeck.drawCard();
			}
		}
				
		if(!finished.equals("quit")){
		for(int i = 0;i<5;i++){
		System.out.print("["+player1.hand[i]+"] ");
		}
		aScore = Score.getScore(player1.hand)*10;
		System.out.println("Your Score: "+aScore);
		player1.health += aScore;
		System.out.println("Your health: "+player1.health+"\n"+"******************************************"+"\n");
		}
		quitGame = finished;
		}
	}

}
