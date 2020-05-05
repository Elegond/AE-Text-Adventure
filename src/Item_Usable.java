
public class Item_Usable extends Item {

	Boolean stapelbar;

	public Item_Usable(String name, String beschreibung, int gewicht, Boolean stapelbar) {
		super(name, beschreibung, gewicht);
		this.stapelbar = stapelbar;

	}

}
