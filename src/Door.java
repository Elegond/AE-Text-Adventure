
public class Door {
	private String[] name = new String[2];
	private String key;
	private Boolean auf_Zu;
	private Boolean abgeschlossen;

	public Door(String bezeichnung0, String bezeichnung1, String schluessel, Boolean offen, Boolean locked) {
		name[0] = bezeichnung0;
		name[1] = bezeichnung1;
		key = schluessel;
		auf_Zu = offen;
		abgeschlossen = locked;		
	}

	public Door(String bezeichnung0, String bezeichnung1) {
		name[0] = bezeichnung0;
		name[1] = bezeichnung1;
		key = null;
		auf_Zu = true;
		abgeschlossen = false;
	}

	public Door(String bezeichnung0, String bezeichnung1, Boolean offen) {
		name[0] = bezeichnung0;
		name[1] = bezeichnung1;
		key = null;
		auf_Zu = offen;
		abgeschlossen = false;
	}

	public String[] getName() {
		return name;
	}

	public String getKey() {
		return key;
	}

	public Boolean getAuf_Zu() {
		return auf_Zu;
	}

	public void setAuf_Zu(Boolean auf_Zu) {
		this.auf_Zu = auf_Zu;
	}

	public Boolean getAbgeschlossen() {
		return abgeschlossen;
	}

	public void setAbgeschlossen(Boolean abgeschlossen) {
		this.abgeschlossen = abgeschlossen;
	}
	
}
