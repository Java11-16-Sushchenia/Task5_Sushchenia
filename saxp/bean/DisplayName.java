package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;;

public class DisplayName extends Tag{

	private String displayName;
	
	public DisplayName(){}
	
	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public void showTag(){
		System.out.println("<"+super.getName()+">"+this.displayName+"</"+super.getName()+">");
	}
	
}
