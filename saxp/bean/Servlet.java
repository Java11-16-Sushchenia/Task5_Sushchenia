package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

public class Servlet extends Tag{
	private String servletName;
	private String servletClass;
	private InitParam initParam;
	
	public Servlet(){}
	
	public String getServletName() {
		return servletName;
	}
	public void setServletName(String servletName) {
		this.servletName = servletName;
	}
	public String getServletClass() {
		return servletClass;
	}
	public void setServletClass(String servletClass) {
		this.servletClass = servletClass;
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
		System.out.println("\t\t<servlet-name>"+this.getServletName()+"</servlet-name>");
		System.out.println("\t\t<servlet-class>"+this.servletClass+"</servlet-class>");
		if(initParam != null){
			System.out.println("\t\t<init-param>");
			System.out.println("\t\t\t<param-name>"+this.initParam.getParamName()+"</param-name>");
			System.out.println("\t\t\t<param-value>"+this.initParam.getParamValue()+"</param-value>");
			System.out.println("\t\t</init-param>");
		}
		System.out.println("</"+super.getName()+">");
	}
}
