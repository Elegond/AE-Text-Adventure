import java.util.Random;

public class Door { // Klasse Tür mit Variablen und überladenem Konstruktor
	private String[] name = new String[2];
	private String key;
	private Boolean open;
	private Boolean locked;
			
	public Door(String name0, String name1, String key, Boolean open, Boolean locked) { // Konstruktor Tür mit Schlüssel
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = key;
		this.open = open; // true = offen | false = geschlossen
		this.locked = locked; // false = offen | true = abgeschlossen
	}

	public Door(String name0, String name1) { // Konstruktor Tür geschlossen aber nicht abgeschlossen
		this.name[0] = name0;
		this.name[1] = name1;
		this.key = null;
		this.open = false;
		this.locked = false;
	}

	public Door(String name0, String name1, Boolean open) { // Konstruktor Tür geöffnet
		name[0] = name0;
		name[1] = name1;
		key = null;
		this.open = open;
		this.locked = false;
	}

	public String getName() { // Getter für Name
		return (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0]);
	}

	public String getKey() { // Getter für Schlüssel
		return key;
	}

	public Boolean getOpen() { // Getter für geöffnet | geschlossen
		return open;
	}

	public void open() { // Funktion für öffnen | schließen einer Tür
		if (!locked) {
			open = !open;
			System.out.println("Du hast die " // Prüfen ob die Tür offen oder geschlossen ist und den Zustand entsprechend anpassen
					+ (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
					+ (open ? " geöffnet" : " geschlossen"));
			Main.p.setStamina(-1); // Ausdauer des Spielers Reduzieren
		}
		if (locked)
			unlock();

	}

	public Boolean getLocked() { // Getter für Den Zustand abgeschlossen | nicht abgeschlossen
		return locked;
	}

	private boolean unlock() { // Funktion für aufschließen einer Tür
		for (Item_Usable i : Main.p.getInventory()) {
			if (i.getName().equalsIgnoreCase(key)) { // Prüfen ob der Schlüssel im Inventar ist
				this.locked = false;
				System.out.println("Du hast die "
						+ (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0]) // Prüfen auf welcher Seite der Tür man sich befindet
						+ " aufgeschlossen");
				Main.p.pop_Inventory(i);
				return true;
			}

		}
		System.out.println("Du hast den " + key + " nicht");
		return false;
	}

	public boolean enter() { // Funktion für das Durchschreiten einer Tür
		if (open) {
			for (Room r : Main.Rooms) {
				for (Door d : r.getDoors()) { // Türen des aktuellen Raumes abrufen 
					if (d.equals(this)) {
						if (this.getName().contains("treppe")) { // Prüfen ob es die Treppe ist, wenn ja -> Zufallsgenerator ob gestürtzt
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
		} else { // Wenn Tür geschlossen Rückmeldung an Spieler
			System.out.println(
					"Die " + (Main.p.getPosition().getRoomName().charAt(0) == name[0].charAt(0) ? name[1] : name[0])
							+ " ist geschlossen");

		}
		return false;

	}
}
