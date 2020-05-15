import java.util.List;

public class Person {
	protected String name;
	protected Boolean geschlecht;
	protected List<Item_Usable> inventar;

	public Person(String name, Boolean geschlecht, List<Item_Usable> inventar) {
		this.name = name;
		this.geschlecht = geschlecht;
		this.inventar = inventar;
	}

	public String getName() {
		return name;
	}

	public Boolean getGeschlecht() {
		return geschlecht;
	}

	public List<Item_Usable> getInventar() {
		return inventar;
	}

	public void pop_Inventar(Item_Usable i) {
		inventar.remove(i);
	}
	public void push_Inventar(Item_Usable i) {
		inventar.add(i);
	}
}
