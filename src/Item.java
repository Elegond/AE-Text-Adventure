
public class Item {
	protected String name, description;
	protected int weight;

	public Item(String name, String description, int weight) {
		this.description = description;
		this.weight = weight;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public int getWeight() {
		return weight;
	}

}
