import java.util.List;

public class NPC extends Person {
	private String[] texts;

	public NPC(String name, Boolean gender, List<Item_Usable> inventory, String[] texts) {
		super(name, gender, inventory);
		this.texts = texts;
	}

	public String[] getTexts() {
		return texts;
	}

}
