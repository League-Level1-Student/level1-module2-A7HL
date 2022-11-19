package _99_extra._05_minion;

public class Minion {
	private String name;
	private int eyes;
	private String color; 
	private String master;
	
	public Minion(String name1, int eyes1, String color1, String master1) {
		this.name = name1;
		this.eyes = eyes1;
		this.color= color1;
		this.master = master1;
		
	}
	public String getName() {
		return name;
	}
	public int getEyes() {
		return eyes;
	}
	public String getColor() {
		return color;
	}
	public String getMaster() {
		return master;
	}
	public void setMaster(String newMaster) {
		master=newMaster;
	}

}
