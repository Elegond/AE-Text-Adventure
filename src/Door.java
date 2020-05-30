import java.util.Random;

public class Door { // Klasse T�r mit Variablen und �berladenem Konstruktor
	private String[] name = new String[2];
	private String key;
	private Boolean open;
	private Boolean locked;
			
	public Door(String name0, String name1, String key, Boolean open, Boolean locked) { // Konstruktor T�r mit Schl�ssel
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = key;
		this.open = open; // true = offen | false = geschlossen
		this.locked = locked; // false = offen | true = abgeschlossen
	}

	public Door(String name0, String name1) { // Konstruktor T�r geschlossen aber nicht abgeschlossen
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = null;
		this.open = false;
		this.locked = false;
	}

	public Door(String name0, String name1, Boolean open) { // Konstruktor T�r ge�ffnet
		name[0] = name0;
		name[1] = name1;
		key = null;
		this.open = open;
		this.locked = false;
	}

	public String getName() { // Getter f�r Name
		return (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0]);
	}

	public String getKey() { // Getter f�r Schl�ssel
		return key;
	}

	public Boolean getOpen() { // Getter f�r ge�ffnet | geschlossen
		return open;
	}

	public void open() { // Funktion f�r �ffnen | schlie�en einer T�r
		if (!locked) {
			open = !open;
			System.out.println("Du hast die " // Pr�fen ob die T�r offen oder geschlossen ist und den Zustand entsprechend anpassen
					+ (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
					+ (open ? " ge�ffnet" : " geschlossen"));
			Main.p.setStamina(-1); // Ausdauer des Spielers Reduzieren
		}
		if (locked)
			unlock();

	}

	public Boolean getLocked() { // Getter f�r Den Zustand abgeschlossen | nicht abgeschlossen
		return locked;
	}

	private boolean unlock() { // Funktion f�r aufschlie�en einer T�r
		for (Item_Usable i : Main.p.getInventory()) {
			if (i.getName().equalsIgnoreCase(key)) { // Pr�fen ob der Schl�ssel im Inventar ist
				this.locked = false;
				System.out.println("Du hast die "
						+ (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0]) // Pr�fen auf welcher Seite der T�r man sich befindet
						+ " aufgeschlossen");
				Main.p.pop_Inventory(i);
				return true;
			}

		}
		System.out.println("Du hast den " + key + " nicht");
		return false;
	}

	public boolean enter() { // Funktion f�r das Durchschreiten einer T�r
		if (open) {
			for (Room r : Main.Rooms) {
				for (Door d : r.getDoors()) { // T�ren des aktuellen Raumes abrufen 
					if (d.equals(this)) {
						if (this.getName().contains("treppe")) { // Pr�fen ob es die Treppe ist, wenn ja -> Zufallsgenerator ob gest�rtzt
							Random rdn = new Random();
							int i = rdn.nextInt(4);
							if (i == 2) {
								System.out.println("\n\nDu bist von der Treppe Gefallen\n\n");
								Main.p.setHealth(-1);
								Main.p.setPosition(Main.Rooms.get(1));
								return true;
							}
						}
						if (!Main.p.getPosition().equals(r)) { // Position in den betretenen Raum setzen
							Main.p.setPosition(r);
							System.out.println("Du hast den Raum " + r.getRoomName() + " betreten");
							return true;
						}
					}
				}
			}
		} else { // Wenn T�r geschlossen R�ckmeldung an Spieler
			System.out.println(
					"Die " + (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
							+ " ist geschlossen");

		}
		return false;

	}
}
