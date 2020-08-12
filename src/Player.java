import java.util.List;

public class Player extends Person {
	private int stamina;
	private int strength;
	private int health;
	private int maxStamina;
	private int maxStrength;
	private int maxHealth;
	private Room position;

	public Player(String name, Boolean gender, List<Item_Usable> Item, int stamina, int strength,
			int health, Room position) {
		super(name, gender, Item);
		this.stamina = stamina;
		this.strength = strength;
		this.health = health;
		this.maxStamina = stamina;
		this.maxStrength = strength;
		this.maxHealth = health;
		this.position = position;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		if (this.stamina + stamina <= 0) {
			System.out.println("Du bist Erschöpft\nDas ist Lebensgefährlich");
			setHealth(-1);
			this.stamina = this.maxStamina;
		}
		this.stamina = this.stamina + stamina;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = this.strength + strength;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (this.health + health <= 0) {
			this.health = 0;
			System.out.println("\n\n\nGame Over\n\n");
			System.exit(0);
		} else
			this.health = this.health + health;
	}

	public Room getPosition() {
		return position;
	}

	public void setPosition(Room r) {
		position = r;
	}

	public int getMaxStamina() {
		return maxStamina;
	}

	public int getMaxStrength() {
		return maxStrength;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

}
