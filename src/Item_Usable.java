
public class Item_Usable extends Item {

	Boolean stapelbar;
	useable u;
	public Item_Usable(String name, String beschreibung, int gewicht, Boolean stapelbar, useable u) {
		super(name, beschreibung, gewicht);
		this.stapelbar = stapelbar;
		this.u = u;
	}

	public interface useable{
		void use();
	}
	public void use() {
		u.use();
	}
	
}
