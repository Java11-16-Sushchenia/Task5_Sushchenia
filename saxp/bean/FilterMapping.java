package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

public class FilterMapping extends Tag{
	private String filterName;
	private String urlPattern;
	private String dispatcher;
	
	public FilterMapping(){}
	
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getUrlPattern() {
		return urlPattern;
	}
	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}
	public String getDispatcher() {
		return dispatcher;
	}
	public void setDispatcher(String dispatcher) {
		this.dispatcher = dispatcher;
	}
	
	@Override
	public void showTag(){
		System.out.println("<"+super.getName()+">");
			System.out.println("\t\t<filter-name>"+this.getFilterName()+"</filter-name>");
			System.out.println("\t\t<url-pattern>"+this.getUrlPattern()+"</url-pattern>");
			System.out.println("\t\t<dispatcher>"+this.getDispatcher()+"</dispatcher>");
		System.out.println("</"+super.getName()+">");
	}
}
