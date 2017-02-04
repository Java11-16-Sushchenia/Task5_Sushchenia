package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

public class WebApp extends Tag{

	private String id;
	private String version;
	
	public WebApp(){}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	@Override
	public void showTag(){
		System.out.print("<"+super.getName());
		
		 if(this.getId() != null){
			 System.out.print(" id='"+this.getId()+"'");
		 }
		 if(this.getVersion() != null){
			 System.out.print(" version='"+this.getVersion()+"'");
		 }
		 
		 System.out.println(">");
	}
}
