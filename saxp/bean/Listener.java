package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

public class Listener extends Tag{
	private String listenerClass;
	
	public Listener(){}

	public String getListenerClass() {
		return listenerClass;
	}

	public void setListenerClass(String listenerClass) {
		this.listenerClass = listenerClass;
	}
	
	@Override 
	public void showTag(){
		System.out.println("<"+super.getName()+">");
		System.out.println("\t\t<listener-class>"+this.getListenerClass()+"</listener-class>");
		System.out.println("</"+super.getName()+">");
	}
}
