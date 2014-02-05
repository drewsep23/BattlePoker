import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	public List<String> Cards = new ArrayList<String>();
	public Deck()
	{
		Cards.add("Ah");
		Cards.add("2h");
		Cards.add("3h");
		Cards.add("4h");
		Cards.add("5h");
		Cards.add("6h");
		Cards.add("7h");
		Cards.add("8h");
		Cards.add("9h");
		Cards.add("1h");
		Cards.add("Jh");
		Cards.add("Qh");
		Cards.add("Kh");
		Cards.add("As");
		Cards.add("2s");
		Cards.add("3s");
		Cards.add("4s");
		Cards.add("5s");
		Cards.add("6s");
		Cards.add("7s");
		Cards.add("8s");
		Cards.add("9s");
		Cards.add("1s");
		Cards.add("Js");
		Cards.add("Qs");
		Cards.add("Ks");
		Cards.add("Ac");
		Cards.add("2c");
		Cards.add("3c");
		Cards.add("4c");
		Cards.add("5c");
		Cards.add("6c");
		Cards.add("7c");
		Cards.add("8c");
		Cards.add("9c");
		Cards.add("1c");
		Cards.add("Jc");
		Cards.add("Qc");
		Cards.add("Kc");
		Cards.add("Ad");
		Cards.add("2d");
		Cards.add("3d");
		Cards.add("4d");
		Cards.add("5d");
		Cards.add("6d");
		Cards.add("7d");
		Cards.add("8d");
		Cards.add("9d");
		Cards.add("1d");
		Cards.add("Jd");
		Cards.add("Qd");
		Cards.add("Kd");
		
		Collections.shuffle(Cards);
		
	}
	
	public String drawCard()
	{
		String myCard;
		myCard = this.Cards.get(0);
		Cards.remove(0);
		return myCard;
	}
	
}
