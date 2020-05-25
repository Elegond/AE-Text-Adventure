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
		if (this.health + health <= 0)
			this.health = 0;
		else
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
