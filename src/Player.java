import java.util.List;

public class Player extends Person{
	private Integer ausdauer;
	private Integer kraft;
	private Integer leben;
	private Room position;
	
	public Player (String NamePerson, Boolean geschlecht, List<Item_Usable> Item,Integer ausdauer, Integer kraft, Integer leben, Room position) {
		super(NamePerson,  geschlecht, Item);
		this.ausdauer = ausdauer;
		this.kraft = kraft;
		this.leben = leben;
		this.position = position;
	}

	public Integer getAusdauer() {
		return ausdauer;
	}

	public void setAusdauer(Integer ausdauer) {
		this.ausdauer = ausdauer;
	}

	public Integer getKraft() {
		return kraft;
	}

	public void setKraft(Integer kraft) {
		this.kraft = kraft;
	}

	public Integer getLeben() {
		return leben;
	}

	public void setLeben(Integer leben) {
		this.leben = leben;
	}

	public Room getPosition() {
		return position;
	}
	
}
