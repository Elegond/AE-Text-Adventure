import java.util.List;

public class Player extends Person {
	private Integer stamina;
	private Integer strength;
	private Integer health;
	private Integer maxStamina;
	private Integer maxStrength;
	private Integer maxHealth;
	private Room position;

	public Player(String name, Boolean gender, List<Item_Usable> Item, Integer stamina, Integer strength,
			Integer health, Room position) {
		super(name, gender, Item);
		this.stamina = stamina;
		this.strength = strength;
		this.health = health;
		this.maxStamina = stamina;
		this.maxStrength = strength;
		this.maxHealth = health;
		this.position = position;
	}

	public Integer getStamina() {
		return stamina;
	}

	public void setStamina(Integer stamina) {
		if (this.stamina + stamina <= 0) {
			System.out.println("Du bist Erschöpft\nDas ist Lebensgefährlich");
			setHealth(-1);
			this.stamina = this.maxStamina;
		}
		this.stamina = this.stamina + stamina;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = this.strength + strength;
	}

	public Integer getHealth() {
		return health;
	}

	public void setHealth(Integer health) {
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

	public Integer getMaxStamina() {
		return maxStamina;
	}

	public Integer getMaxStrength() {
		return maxStrength;
	}

	public Integer getMaxHealth() {
		return maxHealth;
	}

}
