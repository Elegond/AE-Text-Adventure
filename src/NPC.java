import java.util.List;

public class NPC extends Person{
	private String[] texte;
	
	public NPC (String name, Boolean geschlecht, List<Item_Usable> inventar, String[] textinhalte) {
		super(name, geschlecht, inventar);
		//for (int i = 0; i < textinhalte.length; i++) {
		texte = textinhalte;
		//}
	}

	public String[] getTexte() {
		return texte;
	}
	
}
