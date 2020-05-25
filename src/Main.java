import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.awt.GraphicsEnvironment;
import java.beans.FeatureDescriptor;
import java.net.URISyntaxException;

public class Main {
	public static Player p;
	public static List<Room> Rooms = new ArrayList<>();

	public static void main(String[] args) {

		/**
		 * This opens a command line and runs some other class in the jar
		 * 
		 * @author Brandon Barajas https://stackoverflow.com/a/29138847
		 * 
		 *         modification: @author Benjamin Saretzki
		 * 
		 */

		Console console = System.console();
		if (console == null && !GraphicsEnvironment.isHeadless()) {
			String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString().substring(6);

			try {
				if (filename.contains("bin")) // if run in eclipse
					Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "cmd", "/k",
							"java -classpath  \"" + filename + "\" Main & pause & exit" });
				else
					Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "cmd", "/k",
							"java -jar \"" + filename + "\" & pause & exit" });

			} catch (IOException e) {

			}
		} else {
			game();
			System.out.println("\n\nDanke fürs Spielen\n");
		}

		/** --------- */
		System.exit(0);

	}

	public static void game() {
		Item_Usable.usableInterface noUseInt = new Item_Usable.usableInterface() {

			@Override
			public void use(Item_Usable item) {
				System.out.println("Du kannst '" + item.name + "' nicht benutzen");
			}
		};
		Item_Usable.usableInterface foodInterface = new Item_Usable.usableInterface() {

			@Override
			public void use(Item_Usable item) {
				System.out.println(item.getName());
				if (item.getName().equalsIgnoreCase("Apfel")) {
					if (Main.p.getHealth() < Main.p.getMaxHealth())
						Main.p.setHealth(1);
					if (Main.p.getStamina() < Main.p.getMaxStamina())
						Main.p.setStamina(1);
				} else if (item.getName().equalsIgnoreCase("Milch")) {
					if (Main.p.getStamina() + 1 < Main.p.getMaxStamina())
						Main.p.setStamina(2);

				}

			}
		};
		Item_Usable.usableInterface schokoladenInterface = new Item_Usable.usableInterface() {

			@Override
			public void use(Item_Usable item) {
				System.out.println("Glückwunsch du hast die Schokolade gegesen");
				// TODO: Win Function
			}
		};

		// Food
		Item_Usable apfel = new Item_Usable("Apfel", "Ein Leckerer Apfel\n+1 Leben\n+1 Ausdauer", 2, true,
				foodInterface);
		Item_Usable milch = new Item_Usable("Milch", "Fettarme Bio Milch vom Bauern nebenan\n+2 Ausdauer", 2, true,
				foodInterface);
		Item_Usable schokolade = new Item_Usable("Schokolade", "Feinste Hasch Schokolade\n-3Leben", 1, false,
				schokoladenInterface);

		// Keys
		Item_Usable arbeitszimmerKey = new Item_Usable("Arbeitszimmerschlüssel", "Der Schlüssel für das Arbeitszimmer",
				1, false, noUseInt);
		Item_Usable abstellkammerKey = new Item_Usable("Abstellkammerschlüssel", "Der Schlüssel für die Abstellkammer",
				1, false, noUseInt);
		Item_Usable vorratskammerkey = new Item_Usable("Vorratskammerschlüssel", "Der schlüssel für die Vorratskammer",
				1, false, noUseInt);

		// Other
		Item_Usable handy = new Item_Usable("Handy", "Apple iPhone XS Pro Plus von deiner Mama", 2, false, noUseInt);
		Item_Usable geld = new Item_Usable("5 Euroschein", "Ein 5 Euroschein mit einem Wert von 5 Euro", 1, false,
				noUseInt);

		// Items
		Item tv = new Item("Fernseher", "Samsung UE-RU7179 4K Smart TV", 50);
		Item pizza = new Item("Pizza",
				"3 Tage alte Liferando Blumenkohlpizza mit Pesto, Zucchini und Rotkohl\nTötlich für Jedes Kind", 5);
		Item schuh = new Item("Schuh", "Alte durchgelaufene Schuhe mit Löchern", 3);
		Item spielsachen = new Item("Spielsachen", "Benutzte Spielsachen", 1);
		Item bild = new Item("Bild", "Ein Bild von etwas unbeschreibbaren", 2);

		// Item_static

		Item_Static schuschrank = new Item_Static("Schuhschrank", "Ein Schuhschrank", 60,
				new ArrayList<Item>(Arrays.asList(schuh, schuh, schuh)));

		Item_Static flurschrank = new Item_Static("Flurschrank", "Ein Flurschrank", 30,
				new ArrayList<Item>(Arrays.asList(apfel)));
		Item_Static telefontisch = new Item_Static("Telefontisch", "Ein Telefontisch", 25, new ArrayList<Item>(Arrays
				.asList(new Item("Taschentücher", "Eine Packung Taschentücher für den Personlichengebrauch", 1))));

		Item_Static küchenschrank = new Item_Static("Küchenschrank", "Ein Küchenschrank", 35,
				new ArrayList<Item>(Arrays.asList(abstellkammerKey, handy)));
		Item_Static kühlschrank = new Item_Static("Kühlschrank",
				"Ein Samsung RS67N8211B1 Kühl-Gefrierkombinations Kühlschrank", 75,
				new ArrayList<Item>(Arrays.asList(milch, milch, milch, milch, apfel)));

		Item_Static couch = new Item_Static("Couch", "Eine unbequeme Couch", 80,
				new ArrayList<Item>(Arrays.asList(pizza, geld)));
		Item_Static wohnzimmerschrank = new Item_Static("Wohnzimmerschrank",
				"Ein Wohnzimmerschrank\nGebaut mit Honduras Rosenholz das im östlichen Südamerika gefellt wurde", 85,
				new ArrayList<Item>(Arrays.asList()));
		Item_Static wohnzimmertisch = new Item_Static("Wohnzimmertisch",
				"Ein Wohnzimmertisch\nEr hat 4 Beine, 4 Ecken und besteht aus Cocobolo Holz", 25,
				new ArrayList<Item>(Arrays.asList()));

		Item_Static vorratskammerregal = new Item_Static("Vorratskammerregal", "Ein Vorratskammerregal", 35,
				new ArrayList<Item>(Arrays.asList(schokolade)));

		Item_Static abstellkammerregal = new Item_Static("Abstellkammerregal", "Ein Abstellkammerregal", 45,
				new ArrayList<Item>(Arrays.asList(apfel, apfel, apfel, apfel, apfel)));

		Item_Static badezimmerschrank = new Item_Static("Badezimmerschrank", "Ein Badezimmerschrank", 55,
				new ArrayList<Item>(Arrays.asList(new Item("Badezimmersachen", "Sachen die im Badezimmer sind", 4))));

		Item_Static kinderbett = new Item_Static("Kinderbett", "Ein Kinderbett aus Holz", 45,
				new ArrayList<Item>(Arrays.asList(new Item("Bettwäsche", "Bettwäsche mit Fortnite Design", 2))));

		Item_Static bett = new Item_Static("Bett", "Ein stählernes Doppelbett aus Stahl", 75,
				new ArrayList<Item>(Arrays.asList(
						new Item("Bettwäsche", "Bettwäsche mit Star Wars Design und verdächtigen weißen Flecken", 2),
						arbeitszimmerKey)));

		Item_Static arbeitszimmerregal = new Item_Static("Arbeitszimmerregal", "Arbeitszimmerregal", 55,
				new ArrayList<Item>(Arrays.asList(vorratskammerkey)));

		// Türen ertstellen
		Door WohnzimmerFlurEG = new Door("Wohnzimmertür", "Flurtür", true);
		Door WohnzimmerGarten = new Door("Wohnzimmertür", "Gartentür", "Haustürschlüssel", false, true);
		Door EingangStraße = new Door("Eingangtür", "Haustür", "Haustürschlüssel", false, true);
		Door EingangFlurEG = new Door("Eingangstür", "Flurtür");
		Door AbstellkammerFlurEG = new Door("Abstellkammertür", "Flurtür", "Abstellkammerschlüssel", false, true);
		Door KücheFlurEG = new Door("Küchentür", "Flurtür");
		Door KücheVorratskammer = new Door("Küchentür", "Vorratskammertür", "Vorratskammerschlüssel", false, true);
		Door FlurEGFlur1S = new Door("Flurtreppe", "Flurtreppe", true);
		Door BadFlur1S = new Door("Badezimmertür", "Flurtür");
		Door KinderzimmerFlur1S = new Door("Kinderzimmertür", "Flurtür");
		Door SchlafzimmerFlur1S = new Door("Schlafzimmertür", "Flurtür");
		Door ArbeitszimmerFlur1S = new Door("Arbeitszimmertür", "Flurtür", "Arbeitszimmerschlüssel", false, true);

		// Tür Listen erstellen
		List<Door> WohnzimmerDoors = new ArrayList<Door>();
		WohnzimmerDoors.add(WohnzimmerFlurEG);
		WohnzimmerDoors.add(WohnzimmerGarten);
		List<Door> FlurEGDoors = new ArrayList<Door>();
		FlurEGDoors.add(WohnzimmerFlurEG);
		FlurEGDoors.add(EingangFlurEG);
		FlurEGDoors.add(KücheFlurEG);
		FlurEGDoors.add(AbstellkammerFlurEG);
		FlurEGDoors.add(FlurEGFlur1S);
		List<Door> EingangDoors = new ArrayList<Door>();
		EingangDoors.add(EingangFlurEG);
		EingangDoors.add(EingangStraße);
		List<Door> AbstellkammerDoors = new ArrayList<Door>();
		AbstellkammerDoors.add(AbstellkammerFlurEG);
		List<Door> KücheDoors = new ArrayList<Door>();
		KücheDoors.add(KücheFlurEG);
		KücheDoors.add(KücheVorratskammer);
		List<Door> VorratskammerDoors = new ArrayList<Door>();
		VorratskammerDoors.add(KücheVorratskammer);
		List<Door> Flur1SDoors = new ArrayList<Door>();
		Flur1SDoors.add(KinderzimmerFlur1S);
		Flur1SDoors.add(SchlafzimmerFlur1S);
		Flur1SDoors.add(BadFlur1S);
		Flur1SDoors.add(FlurEGFlur1S);
		Flur1SDoors.add(ArbeitszimmerFlur1S);
		List<Door> BadDoors = new ArrayList<Door>();
		BadDoors.add(BadFlur1S);
		List<Door> KinderzimmerDoors = new ArrayList<Door>();
		KinderzimmerDoors.add(KinderzimmerFlur1S);
		List<Door> SchlafzimmerDoors = new ArrayList<Door>();
		SchlafzimmerDoors.add(SchlafzimmerFlur1S);
		List<Door> ArbeitszimmerDoors = new ArrayList<Door>();
		ArbeitszimmerDoors.add(ArbeitszimmerFlur1S);

		// Räume erstellen
		Room Wohnzimmer = new Room("Wohnzimmer", WohnzimmerDoors,
				new ArrayList<Item>(Arrays.asList(couch, tv, wohnzimmerschrank, wohnzimmertisch)),
				new ArrayList<NPC>());
		Room FlurEG = new Room("Flur EG", FlurEGDoors, new ArrayList<Item>(Arrays.asList(telefontisch, flurschrank)),
				new ArrayList<NPC>());
		Room Küche = new Room("Küche", KücheDoors, new ArrayList<Item>(Arrays.asList(küchenschrank, kühlschrank)),
				new ArrayList<NPC>());
		Room Eingang = new Room("Eingang", EingangDoors, new ArrayList<Item>(Arrays.asList(schuschrank)),
				new ArrayList<NPC>());
		Room Abstellkammer = new Room("Abstellkammer", AbstellkammerDoors,
				new ArrayList<Item>(Arrays.asList(abstellkammerregal)), new ArrayList<NPC>());
		Room Vorratskammer = new Room("Vorratskammer", VorratskammerDoors,
				new ArrayList<Item>(Arrays.asList(vorratskammerregal)), new ArrayList<NPC>());
		Room Bad = new Room("Bad", BadDoors, new ArrayList<Item>(Arrays.asList(badezimmerschrank)),
				new ArrayList<NPC>());
		Room Flur1S = new Room("Flur1S", Flur1SDoors, new ArrayList<Item>(Arrays.asList(bild)), new ArrayList<NPC>());
		Room Arbeitszimmer = new Room("Arbeitszimmer", ArbeitszimmerDoors,
				new ArrayList<Item>(Arrays.asList(arbeitszimmerregal)), new ArrayList<NPC>());
		Room Kinderzimmer = new Room("Kinderzimmer", KinderzimmerDoors,
				new ArrayList<Item>(Arrays.asList(spielsachen, kinderbett)), new ArrayList<NPC>());
		Room Schlafzimmer = new Room("Schlafzimmer", SchlafzimmerDoors, new ArrayList<Item>(Arrays.asList(bett)),
				new ArrayList<NPC>());

		Rooms.add(Wohnzimmer);
		Rooms.add(FlurEG);
		Rooms.add(Küche);
		Rooms.add(Eingang);
		Rooms.add(Abstellkammer);
		Rooms.add(Vorratskammer);
		Rooms.add(Bad);
		Rooms.add(Flur1S);
		Rooms.add(Arbeitszimmer);
		Rooms.add(Kinderzimmer);
		Rooms.add(Schlafzimmer);

		List<Item_Usable> InventarPlayer = new ArrayList<Item_Usable>();

		Scanner s = new Scanner(System.in);
		System.out.println("\n\n\n\n");
		System.out.println("Willkommen zum Textadventure");
		System.out.println("\n\n\n\n");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String name = "Peter";
		Boolean geschlecht = false;
		settings: while (true) {
			cls();
			System.out.println("Charakter Einstellungen\n");
			System.out.println("1. Name: " + name);
			System.out.println("2. Geschlecht: " + (geschlecht ? "Weiblich" : "Männlich"));
			System.out.println("Ausdauer: " + (geschlecht ? 15 : 10));
			System.out.println("Kraft: " + (geschlecht ? 10 : 15));
			System.out.println("Leben: 3");
			System.out.println("\n3. OK");
			System.out.print("Auswahl:");
			switch (s.next()) {
			case "1":
				System.out.print("Name: ");
				name = s.next();
				break;
			case "2":
				geschlecht = !geschlecht;
				break;
			case "3":
				break settings;

			default:
				break;
			}
		}
		cls();
		p = new Player(name, geschlecht, InventarPlayer, (geschlecht ? 15 : 10), (geschlecht ? 10 : 15), 3,
				Kinderzimmer);
		System.out.println("Hallo " + p.getName());
		System.out.println("Du bist zur Zeit im Kinderzimmer und willst Schokolade essen\n\nFinde die Schokolade!\n");

		game: while (true) {

			System.out.println("\nWas willst du tun?");
			System.out.println("1. Umschauen");
			System.out.println("2. Inventar");
			System.out.println("3. Status");
			System.out.print("\nAuswahl: ");
			switch (s.next()) {
			case "1":

				break;
			case "2":
				if (p.inventory.size() == 0) {
					System.out.println("\nDein Inventar ist leer");
					break;
				}
				int n = 1;
				for (Item_Usable item_Usable : p.inventory) {
					System.out.println(n + ". " + item_Usable.getName() + "  -  " + item_Usable.getDescription());
					n++;
				}
				System.out.print("\nAuswahl: ");
				try {
					int inv = s.nextInt();

					int auswahl = 1;
					for (Item_Usable item_Usable : p.inventory) {
						if (inv == auswahl) {
							System.out.println(
									auswahl + ". " + item_Usable.getName() + "  -  " + item_Usable.getDescription());

						}
						auswahl++;
					}

				} catch (Exception e) {

				}
				break;
			case "3":
				System.out.println("\nLeben: " + p.getHealth() + "/" + p.getMaxHealth());
				System.out.println("Ausdauer: " + p.getStamina() + "/" + p.getMaxStamina());
				System.out.println("Kraft: " + p.getStrength() + "/" + p.getMaxStrength());
				break;

			case "exit":
				break game;
			default:
				break;
			}

		}

		/*
		 * p.getPosition().getDoors().get(4).open();
		 * p.getPosition().getDoors().get(4).enter();
		 * p.getPosition().getDoors().get(0).open();
		 * 
		 * for (Item_Usable item_Usable : p.getInventory()) { item_Usable.use(); }
		 */
	}

	public static void cls() {
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}