
public class Item {
	private String name, beschreibung;
	int gewicht;

	public Item(String name, String beschreibung, int gewicht) {
		this.beschreibung = beschreibung;
		this.gewicht = gewicht;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public int getGewicht() {
		return gewicht;
	}
	public String untersuchen() {
		// TODO: schreiben der Funktion
		return "";
	}
}
