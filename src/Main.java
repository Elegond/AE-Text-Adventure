import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.awt.GraphicsEnvironment;
import java.net.URISyntaxException;

public class Main {
	public static Player p;
	public static List<Room> Rooms = new ArrayList<>();

	public static void main(String[] args) {

		if (args.length == 0) {
			/**
			 * This opens a command line and runs some other class in the jar
			 * 
			 * @author Brandon Barajas
			 */

			Console console = System.console();
			if (console == null && !GraphicsEnvironment.isHeadless()) {
				String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().toString()
						.substring(6);

				try {
					if (filename.contains("bin"))
						Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "cmd", "/k",
								"java -classpath  \"" + filename + "\" Main" });
					else
						Runtime.getRuntime().exec(new String[] { "cmd", "/c", "start", "cmd", "/k",
								"java -jar \"" + filename + "\" start" });

				} catch (IOException e) {

				}
			} else {
				main(new String[] { "start" });
				System.out.println("\n\nProgram has ended, please type 'exit' to close the console\n");
			}
			System.exit(0);
		}

		Door WohnzimmerFlurEG = new Door("Wohnzimmertür", "Flurtür", true);
		Door WohnzimmerGarten = new Door("Wohnzimmertür", "Gartentür", "Haustürschlüssel", false, true);
		Door EingangStraße = new Door("Eingangtür", "Haustür", "Haustürschlüssel", false, true);
		Door EingangFlurEG = new Door("Eingangstür", "Flurtür");
		Door AbstellkammerFlurEG = new Door("Abstellkammertür", "Flurtür", "Abstellkammerschlüssel", false, true);
		Door KücheFlurEG = new Door("Küchentür", "Flurtür");
		Door KücheVorratskammer = new Door("Küchentür", "Vorratskammertür", "Vorratskammerschlüssel", false, true);
		Door FlurEGFlur1S = new Door("Flurtür", "Flurtür");
		Door BadFlur1S = new Door("Badezimmertür", "Flurtür");
		Door KinderzimmerFlur1S = new Door("Kinderzimmertür", "Flurtür");
		Door SchlafzimmerFlur1S = new Door("Schlafzimmertür", "Flurtür");
		Door ArbeitszimmerFlur1S = new Door("Arbeitszimmertür", "Flurtür", "Arbeitszimmerschlüssel", false, true);
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

		Room Wohnzimmer = new Room("Wohnzimmer", WohnzimmerDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room FlurEG = new Room("Flur EG", FlurEGDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Küche = new Room("Küche", KücheDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Eingang = new Room("Eingang", EingangDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Abstellkammer = new Room("Abstellkammer", AbstellkammerDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Vorratskammer = new Room("Vorratskammer", VorratskammerDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Bad = new Room("Bad", BadDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Flur1S = new Room("Flur1S", Flur1SDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Arbeitszimmer = new Room("Arbeitszimmer", ArbeitszimmerDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Kinderzimmer = new Room("Kinderzimmer", KinderzimmerDoors, new ArrayList<Item>(), new ArrayList<NPC>());
		Room Schlafzimmer = new Room("Schlafzimmer", SchlafzimmerDoors, new ArrayList<Item>(), new ArrayList<NPC>());

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
		Item_Usable.usableInterface noUseInt = new Item_Usable.usableInterface() {

			@Override
			public void use(Item_Usable item) {
				System.out.println("Du kannst '" + item.name + "' nicht benutzen");
			}
		};
		Item_Usable.usableInterface apfelint = new Item_Usable.usableInterface() {

			@Override
			public void use(Item_Usable item) {
				System.out.println(item.getName());
				Main.p.setLife(Main.p.getLife() + 1);

			}
		};
		List<Item_Usable> InventarPlayer = new ArrayList<Item_Usable>();
		Item_Usable itm1 = new Item_Usable("Apfel", "Ein Leckerer Apfel", 2, true, apfelint);
		InventarPlayer.add(itm1);
		InventarPlayer.add(new Item_Usable("Apfel2", "Ein Leckerer Apfel", 2, true, apfelint));

		InventarPlayer.add(new Item_Usable("Axt", "Ein Tötliche Axt", 5, false, new Item_Usable.usableInterface() {

			@Override
			public void use(Item_Usable item) {
				System.out.println(item.getName());
				if (p instanceof Player) {
					if (Main.p.getStamina() > 2) {
						Main.p.setStamina(Main.p.getStamina() - 2);
						System.out.println("Axt benutzt");
					} else {
						System.out.println("Axt kann nicht benutzt werden benutzt");
					}
				}

			}
		}));

		InventarPlayer.add(itm1);
		InventarPlayer.add(itm1);
		InventarPlayer.add(itm1);
		InventarPlayer
				.add(new Item_Usable("Arbeitszimmerschlüssel", "Schlüssel fürs Arbeitszimmer", 0, false, noUseInt));

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
			try {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

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

		p = new Player(name, geschlecht, InventarPlayer, 10, 10, 10, Flur1S);
		System.out.println("Hallo " + p.getName());
		/*
		 * p.getPosition().getDoors().get(4).open();
		 * p.getPosition().getDoors().get(4).enter();
		 * p.getPosition().getDoors().get(0).open();
		 * 
		 * for (Item_Usable item_Usable : p.getInventory()) { item_Usable.use(); }
		 */
	}

}