import java.util.ArrayList;
import java.util.List;

public class Item_Static extends Item {

	private List<Item> content;
	public Item_Static(String name, String description, int gewicht,ArrayList<Item> arrayList) {
		super(name, description, gewicht);
		this.content = arrayList;
	}
	public void push_Content(Item_Usable i) {
		content.add(i);
		
	}
	public void pop_Content(Item_Usable i) {
		content.remove(i);
		
	}
	public List<Item> getContent() {
		return content;
	}
}
