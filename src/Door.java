
public class Door {
	private String[] name = new String[2];
	private String key;
	private Boolean open_close;
	private Boolean locked;

	public Door(String name0, String name1, String key, Boolean open_close, Boolean locked) {
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = key;
		this.open_close = open_close; // true = offen | false = geschlossen
		this.locked = locked; // false = offen | true = abgeschlossen
	}

	public Door(String name0, String name1) {
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = null;
		this.open_close = true;
		this.locked = false;
	}

	public Door(String name0, String name1, Boolean open_close) {
		name[0] = name0;
		name[1] = name1;
		key = null;
		this.open_close = open_close;
		this.locked = false;
	}

	public String[] getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

	public Boolean getOpen_close() {
		return open_close;
	}

	public void setOpen_close() {
		if (locked)
			unlock();
		if (!locked)
			open_close = !open_close;

	}

	public Boolean getLocked() {
		return locked;
	}

	public boolean unlock() {
		for (Item_Usable i : Main.p.getInventory()) {
			if (i.getName().equalsIgnoreCase(key)) {
				this.locked = false;
				System.out.println("Du hast die "
						+ (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
						+ " aufgeschlossen");
				return true;
			}

		}
		System.out.println("Du hast den " + key + " nicht");
		return false;
	}

}
