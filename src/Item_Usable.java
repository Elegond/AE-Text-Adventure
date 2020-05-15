
public class Item_Usable extends Item {

	Boolean stackable;
	usableInterface u;
	public Item_Usable(String name, String description, int gewicht, Boolean stackable, usableInterface u) {
		super(name, description, gewicht);
		this.stackable = stackable;
		this.u = u;
	}

	public interface usableInterface {
		void use(Item_Usable item, Person p);
	}
	public void use(Person p) {
		u.use(this, p);
	}
	
}
