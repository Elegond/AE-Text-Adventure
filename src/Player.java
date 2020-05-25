import java.util.List;

public class Player extends Person{
	private Integer stamina;
	private Integer strength;
	private Integer life;
	private Room position;
	
	public Player (String name, Boolean gender, List<Item_Usable> Item, Integer Stamina, Integer strength, Integer life, Room position) {
		super(name, gender, Item);
		this.stamina = Stamina;
		this.strength = strength;
		this.life = life;
		this.position = position;
	}

	public Integer getStamina() {
		return stamina;
	}

	public void setStamina(Integer stamina) {
		this.stamina = stamina;
	}

	public Integer getStrength() {
		return strength;
	}

	public void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getLife() {
		return life;
	}

	public void setLife(Integer life) {
		this.life = life;
	}

	public Room getPosition() {
		return position;
	}
	public void setPosition(Room r) {
		position=r;
	}
	
}
