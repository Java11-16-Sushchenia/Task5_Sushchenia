package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

public class ServletMapping extends Tag{
	private String servletName;
	private String urlPattern;

	public ServletMapping(){}
	
	public String getServletName() {
		return servletName;
	}

	public void setServletName(String servletName) {
		this.servletName = servletName;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}
	
	@Override 
	public void showTag(){
		System.out.println("<"+super.getName()+">");
		System.out.println("\t\t<servlet-name>"+this.getServletName()+"</servlet-name>");
		System.out.println("\t\t<url-pattern>"+this.getUrlPattern()+"<url-pattern>");
		System.out.println("</"+super.getName()+">");
	}
}
