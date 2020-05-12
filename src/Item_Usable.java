
public class Item_Usable extends Item {

	Boolean stapelbar;
	usableInterface u;
	public Item_Usable(String name, String beschreibung, int gewicht, Boolean stapelbar, usableInterface u) {
		super(name, beschreibung, gewicht);
		this.stapelbar = stapelbar;
		this.u = u;
	}

	public interface usableInterface{
		void use(Item_Usable item);
	}
	public void use() {
		u.use(this);
	}
	
}
