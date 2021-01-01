package model;

public class Note {
	private int id;
	private String title;
	private String despt;
	
	public Note(String title, String despt) {
		super();
		this.title = title;
		this.despt = despt;
	}

	public Note(int id, String title, String despt) {
		super();
		this.id = id;
		this.title = title;
		this.despt = despt;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDespt() {
		return despt;
	}
	public void setDespt(String despt) {
		this.despt = despt;
	}

	
}
