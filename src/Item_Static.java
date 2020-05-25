import java.util.List;

public class Item_Static extends Item {

	private List<Item_Usable> content;
	public Item_Static(String name, String description, int gewicht,List<Item_Usable> content) {
		super(name, description, gewicht);
		this.content = content;
	}
	public void push_Content(Item_Usable i) {
		content.add(i);
		
	}
	public void pop_Content(Item_Usable i) {
		content.remove(i);
		
	}
	public List<Item_Usable> getContent() {
		return content;
	}
}
