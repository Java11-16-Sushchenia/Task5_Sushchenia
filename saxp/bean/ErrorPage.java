package by.asushenya.saxp.bean;


import by.asushenya.saxp.bean.behaviour.Tag;

public class ErrorPage extends Tag{
	private String exceptionType;
	private String errorCode; 
	private String location;
	
	public ErrorPage(){}
	
	public String getExceptionType() {
		return exceptionType;
	}
	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	@Override 
	public void showTag(){
		System.out.println("<"+super.getName()+">");
		
		if(this.getExceptionType() != null){
			System.out.println("\t\t<exception-type>"+this.getExceptionType()+"</exception-type>");
		} 
		
		if(this.getErrorCode() != null){
			System.out.println("\t\t<error-code>"+this.getErrorCode()+"</error-code>");
		}
		
		System.out.println("\t\t<location>"+this.getLocation()+"</location>");
		System.out.println("</"+super.getName()+">");
	}
}
