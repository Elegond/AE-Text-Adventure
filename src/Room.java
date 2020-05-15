import java.util.List;

public class Room {

	private String roomName;
	private List<Door> doors;
	private List<Item> inventoy;
	private List<NPC> npcs;

	public Room(String roomName, List<Door> doors, List<Item> inventoy, List<NPC> npcs) {
		this.roomName = roomName;
		this.doors = doors;
		this.inventoy = inventoy;
		this.npcs = npcs;

	}

	public String getRoomName() {
		return roomName;
	}

	public List<Door> getDoors() {
		return doors;
	}

	public List<Item> getInventoy() {
		return inventoy;
	}

	public List<NPC> getNpcs() {
		return npcs;
	}

	public void pop_NPC(NPC del_npc) {
		npcs.remove(del_npc);
	}

	public void push_NPC(NPC add_npc) {
		npcs.add(add_npc);
	}

	public void pop_Inventoy(Item i) {
		inventoy.remove(i);
	}

	public void push_Inventoy(Item i) {
		inventoy.add(i);
	}

}
