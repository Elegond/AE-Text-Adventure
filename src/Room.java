import java.util.List;

public class Room {

	private String roomName;
	private List<Door> doors;
	private List<Item> inhalt;
	private List<NPC> npcs;

	public Room(String roomName, List<Door> doors, List<Item> inhalt, List<NPC> npcs) {
		this.roomName = roomName;
		this.doors = doors;
		this.inhalt = inhalt;
		this.npcs = npcs;

	}

	public String getRoomName() {
		return roomName;
	}

	public List<Door> getDoors() {
		return doors;
	}

	public List<Item> getInhalt() {
		return inhalt;
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

	public void pop_Inhalt(Item i) {
		inhalt.remove(i);
	}

	public void push_Inhalt(Item i) {
		inhalt.add(i);
	}

}
