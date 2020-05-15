import java.util.List;

public class Person {
	protected String name;
	protected Boolean gender;
	protected List<Item_Usable> inventory;

	public Person(String name, Boolean gender, List<Item_Usable> inventory) {
		this.name = name;
		this.gender = gender;
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public Boolean getGender() {
		return gender;
	}

	public List<Item_Usable> getInventory() {
		return inventory;
	}

	public void pop_Inventar(Item_Usable i) {
		inventory.remove(i);
	}
	public void push_Inventar(Item_Usable i) {
		inventory.add(i);
	}
}
