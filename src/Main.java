import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Door WohnzimmerFlur = new Door("Wohnzimmertür", "Flurtür", true);
		System.out.println(WohnzimmerFlur.getName()[0]);
		System.out.println(WohnzimmerFlur.getName()[1]);
		System.out.println(WohnzimmerFlur.getKey());
		System.out.println(WohnzimmerFlur.getAuf_Zu());
		System.out.println(WohnzimmerFlur.getAbgeschlossen());
		Item_Usable.usableInterface apfelint = new Item_Usable.usableInterface() {
			
			@Override
			public void use(Item_Usable item) {
				System.out.println(item.getName());
				
			}
		};
		List<Item_Usable> InventarHerbert = new ArrayList<Item_Usable>();
		Item_Usable itm1 = new Item_Usable("Apfel", "Ein Leckerer Apfel", 2, true, apfelint);
		InventarHerbert.add(itm1);
		InventarHerbert.add(new Item_Usable("Apfel2", "Ein Leckerer Apfel", 2, true, apfelint));
		
		InventarHerbert.add(new Item_Usable("Apfel3", "Ein Leckerer Apfel", 2, true, new Item_Usable.usableInterface() {
			
			@Override
			public void use(Item_Usable item) {
				System.out.println(item.getName());
				
			}
		}));
		Person Herbert = new Person("Herbert", false, InventarHerbert);
		
		System.out.println(Herbert.getName());
		System.out.println(Herbert.getGeschlecht());
		for (Item_Usable item_Usable : Herbert.getInventar()) {
			item_Usable.use();
		} 

	}

}