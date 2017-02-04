package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

public class Filter extends Tag{
	private String filterName;
	private String filterClass;
	private InitParam initParam;
	
	public Filter(){}
	
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	
	public String getFilterClass() {
		return filterClass;
	}
	public void setFilterClass(String filterClass) {
		this.filterClass = filterClass;
	}
	
	public InitParam getInitParam() {
		return initParam;
	}
	public void setInitParam(InitParam initParam) {
		this.initParam = initParam;
	}
	
	@Override 
	public void showTag(){
		System.out.println("<"+super.getName()+">");
		System.out.println("\t\t<filter-name>"+this.getFilterName()+"</filter-name>");
		System.out.println("\t\t<filter-class>"+this.getFilterClass()+"</filter-class>");
		if(initParam != null){
			System.out.println("\t\t<init-param>");
			System.out.println("\t\t\t<param-name>"+this.initParam.getParamName()+"</param-name>");
			System.out.println("\t\t\t<param-value>"+this.initParam.getParamValue()+"</param-value>");
			System.out.println("\t\t</init-param>");
		}
		System.out.println("</"+super.getName()+">");
	}
}
