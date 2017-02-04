package by.asushenya.saxp.bean.behaviour;

public abstract class Tag {
	private String name;
	
	public Tag(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void showTag();	
}
