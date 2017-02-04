package by.asushenya.saxp.service.impl;

import by.asushenya.saxp.bean.behaviour.Tag;
import by.asushenya.saxp.bean.WelcomeFileList;
import by.asushenya.saxp.bean.WebApp;
import by.asushenya.saxp.util.WebXMLTagName;
import by.asushenya.saxp.bean.DisplayName;
import by.asushenya.saxp.bean.Filter;
import by.asushenya.saxp.bean.FilterMapping;
import by.asushenya.saxp.bean.InitParam;
import by.asushenya.saxp.bean.Listener;
import by.asushenya.saxp.bean.Servlet;
import by.asushenya.saxp.bean.ServletMapping;
import by.asushenya.saxp.bean.ErrorPage;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.List;
import java.util.ArrayList;

public class WebXMLSAXHandler extends DefaultHandler{
	
	private List<Tag> tagList = new ArrayList<Tag>();
	
	private WebApp 			webApp;
	private DisplayName 	displayName;
	private WelcomeFileList welcomeFileList;
	private Filter 			filter;
	private InitParam 		initParam;
	private FilterMapping 	filterMapping;
	private Listener 		listener;
	private Servlet 		servlet;
	private ServletMapping 	servletMapping;
	private ErrorPage 		errorPage;
	
	private StringBuilder 	text;
		
	public List<Tag> getTagList(){
		return this.tagList;
	}
	
	public void startDocument() throws SAXException {
		System.out.println("SAX Prser");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("Parsing ended.");
		
		webApp = new WebApp();
		webApp.setName("/web-app");
		tagList.add(webApp);
		webApp = null;
	}
	
	public void startElement(String uri, String localName, String qName, Attributes attributes)
																throws SAXException{
				
		text = new StringBuilder();
		
		if(localName.equals("web-app")){
			
			webApp = new WebApp();	
			webApp.setName("web-app");
			webApp.setId( attributes.getValue("id"));
			webApp.setVersion( attributes.getValue("version"));			
			tagList.add(webApp);			
			webApp = null;
		}
		
		WebXMLTagName tagName = WebXMLTagName.valueOf(localName.toUpperCase().replace("-", "_"));
				
		switch(tagName){
		
		case DISPLAY_NAME:
			 displayName = new DisplayName();
			 displayName.setName("display-name");
			 break;
			 
		case WELCOME_FILE_LIST:
			 welcomeFileList = new WelcomeFileList();
			 welcomeFileList.setName("welcome-file-list");
			 break;
			 
		case FILTER:
			filter = new Filter();
			filter.setName("filter");			
			break;
			
		case FILTER_MAPPING:
			filterMapping = new FilterMapping();
			filterMapping.setName("filter-mapping");
			break;
			
		case INIT_PARAM:
			initParam = new InitParam();
			break;
			
		case LISTENER:
			listener = new Listener();
			listener.setName("listener");
			break;
			
		case SERVLET:
			servlet = new Servlet();
			servlet.setName("servlet");
			break;
					
		case SERVLET_MAPPING:
			servletMapping = new ServletMapping();
			servletMapping.setName("servlet-mapping");
			break;	
			
		case ERROR_PAGE:
			errorPage = new ErrorPage();
			errorPage.setName("error-page");
			break;
			
		default:
			break;		
		}
	}
	
	public void characters(char[] buffer, int start, int length){
		text.append(buffer, start, length);
	}
	
	public void endElement(String uri, String localName, String qName)
													throws SAXException{
		WebXMLTagName tagName = WebXMLTagName.valueOf(localName.toUpperCase().replace("-", "_"));
		
		switch(tagName){
		
		case DISPLAY_NAME:
			displayName.setDisplayName(text.toString());
			tagList.add(displayName);
			displayName = null;
			break;
			
		case WELCOME_FILE:
			welcomeFileList.addWelcomeFile(text.toString());
			break;
			
		case WELCOME_FILE_LIST:
			tagList.add(welcomeFileList);
			welcomeFileList = null;
			break;
			
		case FILTER_NAME:			
			if(filter != null){
				filter.setFilterName(text.toString());
			} else if (filterMapping != null){
				filterMapping.setFilterName(text.toString());
			}
			break;			
			
		case FILTER_CLASS:
			filter.setFilterClass(text.toString());
			break;
			
		case PARAM_NAME:
			initParam.setParamName(text.toString());
			break;
			
		case PARAM_VALUE:
			initParam.setParamValue(text.toString());
			break;
			
		case INIT_PARAM:
			if(filter != null){
				filter.setInitParam(initParam);
			} else if(servlet != null){
				servlet.setInitParam(initParam);
					}
			
			initParam = null;
			break;
			
		case FILTER:
			tagList.add(filter);
			filter = null;
			
		case URL_PATTERN:
			if(filterMapping != null){
				filterMapping.setUrlPattern(text.toString());
			} else if(servletMapping != null){
				servletMapping.setUrlPattern(text.toString());
			}		
			break;
			
		case DISPATCHER:
			filterMapping.setDispatcher(text.toString());
			break;
			
		case FILTER_MAPPING:
			tagList.add(filterMapping);
			filterMapping = null;			
			break;
			
		case LISTENER_CLASS:
			listener.setListenerClass(text.toString());
			break;
			
		case LISTENER:
			tagList.add(listener);
			listener = null;
			break;
			
		case SERVLET_NAME:
			if(servlet != null){
				servlet.setServletName(text.toString());
			} else if(servletMapping != null){
				servletMapping.setServletName(text.toString());
			}			
			break;
			
		case SERVLET_CLASS:
			servlet.setServletClass(text.toString());
			break;
			
		case SERVLET:
			tagList.add(servlet);
			servlet = null;			
			break;
			
		case SERVLET_MAPPING:
			tagList.add(servletMapping);
			servletMapping = null;
			break;
			
		case EXCEPTION_TYPE:
			errorPage.setExceptionType(text.toString());
			break;
			
		case ERROR_CODE:
			errorPage.setErrorCode(text.toString());
			break;
			
		case LOCATION:
			errorPage.setLocation(text.toString());
			break;
			
		case ERROR_PAGE:
			tagList.add(errorPage);
			errorPage = null;
			break;
			
		default:
			break;
		}			
	}
	public void warning (SAXParseException exception){
		System.err.println("WARNING: line "+exception.getLineNumber()+
											": "+exception.getMessage());
	}
	
	public void error (SAXParseException exception ){
		System.err.println("ERROR: line "+exception.getLineNumber()+
										": "+exception.getMessage());
	}
	
	public void fatalError(SAXParseException exception )
									throws SAXParseException{
		System.err.println("FATAL: line "+exception.getLineNumber()+
										": "+exception.getMessage());
		throw(exception);
	}
}
