
public class Item_Usable extends Item {

	Boolean stackable;
	usableInterface u;

	public Item_Usable(String name, String description, int weight, Boolean stackable, usableInterface u) {
		super(name, description, weight);
		this.stackable = stackable;
		this.u = u;
	}

	public interface usableInterface {
		void use(Item_Usable item);
	}

	public void use() {
		u.use(this);
	}

	public void pickup(Item_Static s) {
		if (Main.p.getStrength() > getWeight()) {

			s.pop_Content(this);
			Main.p.push_Inventory(this);
			Main.p.setStrength(getWeight() * -1);
			System.out.println("\n    Du hast " + getName() + " Aufgenommen\n\n");
		} else
			System.out.println("\n   Du hast nicht genug kraft um " + getName() + " zu tragen\n\n");
	}

	public void drop(Item_Static s) {

		s.push_Content(this);
		Main.p.pop_Inventory(this);
		Main.p.setStrength(getWeight());

	}
}
