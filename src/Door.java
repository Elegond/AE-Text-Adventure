
public class Door {
	private String[] name = new String[2];
	private String key;
	private Boolean open;
	private Boolean locked;

	public Door(String name0, String name1, String key, Boolean open, Boolean locked) {
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = key;
		this.open = open; // true = offen | false = geschlossen
		this.locked = locked; // false = offen | true = abgeschlossen
	}

	public Door(String name0, String name1) {
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = null;
		this.open = false;
		this.locked = false;
	}

	public Door(String name0, String name1, Boolean open) {
		name[0] = name0;
		name[1] = name1;
		key = null;
		this.open = open;
		this.locked = false;
	}

	public String[] getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

	public Boolean getOpen() {
		return open;
	}

	public void open() {
		if (!locked) {
			open = !open;
			System.out.println("Du hast die "
					+ (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
					+ (open ? " geöffnet" : " geschlossen"));
		}
		if (locked)
			unlock();
		

	}

	public Boolean getLocked() {
		return locked;
	}

	private boolean unlock() {
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

	public void enter() {
		if (open) {
			for (Room r : Main.Rooms) {
				for (Door d : r.getDoors()) {
					if(d.equals(this)) {
						if(!Main.p.getPosition().getRoomName().equalsIgnoreCase(r.getRoomName())) {
							Main.p.setPosition(r);
							System.out.println("Du hast den Raum "+r.getRoomName()+" betreten");
						}
					}
				}
			}
		} else {
			System.out.println(
					"Die " + (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
							+ "ist geschlossen");
		}

	}
}
