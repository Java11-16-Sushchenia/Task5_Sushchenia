package by.asushenya.saxp.service.impl;

import by.asushenya.saxp.bean.behaviour.Tag;
import by.asushenya.saxp.util.WebXMLTagName;
import by.asushenya.saxp.bean.DisplayName;
import by.asushenya.saxp.bean.ErrorPage;
import by.asushenya.saxp.bean.WebApp;
import by.asushenya.saxp.bean.WelcomeFileList;
import by.asushenya.saxp.bean.Filter;
import by.asushenya.saxp.bean.FilterMapping;
import by.asushenya.saxp.bean.InitParam;
import by.asushenya.saxp.bean.Listener;
import by.asushenya.saxp.bean.Servlet;
import by.asushenya.saxp.bean.ServletMapping;

import java.util.List;
import java.util.ArrayList;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class StAXProcess {	
	
	public static List<Tag> process(XMLStreamReader reader)
									throws XMLStreamException{		
		
		List<Tag> tagList = new ArrayList<Tag>();
		
		WebXMLTagName   elementName 	= null;
		
		WebApp 			webApp 			= null;
		DisplayName 	displayName 	= null;
		WelcomeFileList welcomeFileList = null;
		Filter 			filter 			= null;
	    InitParam 		initParam 		= null;
		FilterMapping 	filterMapping 	= null;
		Listener 		listener 		= null;
		Servlet 		servlet 		= null;
		ServletMapping 	servletMapping 	= null;
		ErrorPage 		errorPage 		= null;
		
		
		while(reader.hasNext()){
			
			int type = reader.next();
			
			switch(type){
			case XMLStreamConstants.START_ELEMENT:
				elementName = WebXMLTagName.getElementTagName(reader.getLocalName());
				
				switch(elementName){
				case WEB_APP:
					webApp= new WebApp();
					webApp.setName("web-app");
					
					String id = reader.getAttributeValue(null, "id");
					String version = reader.getAttributeValue(null, "version");
					
					webApp.setId(id);
					webApp.setVersion(version);
					
					tagList.add(webApp);
					webApp = null;
					break;
					
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
					
				case INIT_PARAM:
					initParam = new InitParam();
					break;
					
				case FILTER_MAPPING:
					filterMapping = new FilterMapping();
					filterMapping.setName("filter-mapping");
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
				break;
				
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				
				if(text.isEmpty()){
					break;
				}
				
				switch(elementName){
				case DISPLAY_NAME:
					displayName.setDisplayName(text);
					break;
					
				case WELCOME_FILE:
					welcomeFileList.addWelcomeFile(text);
					break;
					
				case FILTER_NAME:
					if(filter != null){
						filter.setFilterName(text);
					} else if(filterMapping != null){
						filterMapping.setFilterName(text);
					}
					break;
					
				case FILTER_CLASS:
					filter.setFilterClass(text);
					break;
					
				case PARAM_NAME:
					initParam.setParamName(text);
					break;
					
				case PARAM_VALUE:
					initParam.setParamValue(text);
					break;
				 
				case URL_PATTERN:
					if(filterMapping != null){
						filterMapping.setUrlPattern(text);
					} else if(servletMapping != null){
						servletMapping.setUrlPattern(text);
					}
					break;
					
				case DISPATCHER:
					filterMapping.setDispatcher(text);
					break;
					
				case LISTENER_CLASS:
					listener.setListenerClass(text);
					break;
					
				case SERVLET_NAME:					
					if(servlet != null){
						servlet.setServletName(text);
					} else if (servletMapping != null){
						servletMapping.setServletName(text);
					}
					break;
					
				case SERVLET_CLASS:
					servlet.setServletClass(text);
					break;
					
				case EXCEPTION_TYPE:
					errorPage.setExceptionType(text);
					break;
					
				case ERROR_CODE:
					errorPage.setErrorCode(text);
					break;
					
				case LOCATION:
					errorPage.setLocation(text);
					break;
					
				default:
					break;
				}
				break;
				
			case XMLStreamConstants.END_ELEMENT:
				elementName = WebXMLTagName.getElementTagName(reader.getLocalName());
				
				switch(elementName){
				case DISPLAY_NAME:
					tagList.add(displayName);
					displayName = null;
					break;
					
				case WELCOME_FILE_LIST:
					tagList.add(welcomeFileList);
					welcomeFileList = null;
					break;
					
				case FILTER:
					tagList.add(filter);
					filter = null;
					break;
					
				case INIT_PARAM:
					if(filter != null){
						filter.setInitParam(initParam);
					} else if (servlet != null){
						servlet.setInitParam(initParam);
					}
					initParam = null;
					break;
					
				case FILTER_MAPPING:
					tagList.add(filterMapping);
					filterMapping = null;
					break;
					
				case LISTENER:
					tagList.add(listener);
					listener = null;
					break;
					
				case SERVLET:
					tagList.add(servlet);
					servlet = null;
					break;
					
				case SERVLET_MAPPING:
					tagList.add(servletMapping);
					servletMapping = null;
					break;
					
				case ERROR_PAGE:
					tagList.add(errorPage);
					errorPage = null;
					break;
					
				default:
					break;					
				}
				break;
				
			case XMLStreamConstants.END_DOCUMENT:
				webApp = new WebApp();
				webApp.setName("/web-app");
				tagList.add(webApp);
				webApp= null;
				break;
			}			
		}
		return tagList;
	}
}
