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

		List<Item_Usable> InventarHerbert = new ArrayList<Item_Usable>();
		Item_Usable itm1 = new Item_Usable("Apfel", "Ein Leckerer Apfel", 2, true, new Item_Usable.useable() {
			
			@Override
			public void use() {
				System.out.println("Apfel");
				
			}
		});
		InventarHerbert.add(itm1);
		InventarHerbert.add(new Item_Usable("Apfel2", "Ein Leckerer Apfel", 2, true, new Item_Usable.useable() {
			
			@Override
			public void use() {
				System.out.println("Apfel2");
				
			}
		}));
		
		InventarHerbert.add(new Item_Usable("Apfel3", "Ein Leckerer Apfel", 2, true, new Item_Usable.useable() {
			
			@Override
			public void use() {
				System.out.println("Apfel3");
				
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