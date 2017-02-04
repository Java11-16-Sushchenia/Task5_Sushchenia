package by.asushenya.saxp.service.impl;

import java.io.IOException;

import by.asushenya.saxp.bean.behaviour.Tag;
import by.asushenya.saxp.bean.WelcomeFileList;
import by.asushenya.saxp.bean.WebApp;
import by.asushenya.saxp.bean.DisplayName;
import by.asushenya.saxp.bean.Filter;
import by.asushenya.saxp.bean.FilterMapping;
import by.asushenya.saxp.bean.InitParam;
import by.asushenya.saxp.bean.Listener;
import by.asushenya.saxp.bean.Servlet;
import by.asushenya.saxp.bean.ServletMapping;
import by.asushenya.saxp.bean.ErrorPage;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.apache.xerces.parsers.DOMParser; 

import java.util.List;
import java.util.ArrayList;

public class DOMWebXMLParser {
	public static List<Tag> getTagList(String fileName)
						throws SAXException, IOException {
		
		DOMParser parser = new DOMParser();		
		
		parser.parse(fileName);		
	
		Document document = parser.getDocument();
		
		Element root = document.getDocumentElement();
		
		List<Tag> tagList = new ArrayList<Tag>();
		
		WebApp webApp = new WebApp();
		webApp.setName("web-app");
		webApp.setId(root.getAttribute("id")); 
		webApp.setVersion(root.getAttribute("version"));
		
		tagList.add(webApp);		
		
		NodeList displayNameNodes = root.getElementsByTagName("display-name");				
		for(int i = 0;i< displayNameNodes.getLength();i++){
				
			DisplayName displayName = new DisplayName();
			displayName.setName("display-name");			
				
			displayName.setDisplayName(	displayNameNodes.item(i).getTextContent());
			tagList.add(displayName);
		}
		
		NodeList welcomeFileLisitNodes = root.getElementsByTagName("welcome-file-list");
		for(int i = 0;i<welcomeFileLisitNodes.getLength();i++){
			
			WelcomeFileList welcomeFileList = new WelcomeFileList();
			welcomeFileList.setName("welcome-file-list");
			
			Element welcomeFileNode = (Element) welcomeFileLisitNodes.item(i);
			NodeList welcomeFileNodes =	welcomeFileNode.getElementsByTagName("welcome-file");
			
			for(int wf = 0;wf<welcomeFileNodes.getLength();wf++){
				
				Element welcomeFileElement = (Element)welcomeFileNodes.item(wf);
				welcomeFileList.addWelcomeFile(welcomeFileElement.getTextContent());				
			}	
			tagList.add(welcomeFileList);			
		}
		
		NodeList filterNodes = root.getElementsByTagName("filter");
		for(int i = 0;i<filterNodes.getLength();i++){
			
			Filter filter = new Filter();
			filter.setName("filter");
			
			Element filterNode = (Element) filterNodes.item(i);			
				
			filter.setFilterName(getSingleChild(filterNode,"filter-name").getTextContent().trim());
			filter.setFilterClass(getSingleChild(filterNode, "filter-class").getTextContent().trim());
			
			Element initParamNode = getSingleChild(filterNode, "init-param");
			if(initParamNode != null){
				InitParam initParam = new InitParam();
				initParam.setParamName(getSingleChild(initParamNode, "param-name").getTextContent().trim());
				initParam.setParamValue(getSingleChild(initParamNode, "param-value").getTextContent().trim());
				filter.setInitParam(initParam);
			}
			
			tagList.add(filter);			
		}
		
		NodeList filterMappingNodes = root.getElementsByTagName("filter-mapping");
		for(int i = 0;i<filterMappingNodes.getLength();i++){
			FilterMapping filterMapping = new FilterMapping();
			filterMapping.setName("filter-mapping");
			
			Element filterMappingNode = (Element) filterMappingNodes.item(i);
			filterMapping.setFilterName(getSingleChild(filterMappingNode, "filter-name").getTextContent().trim());
			filterMapping.setUrlPattern(getSingleChild(filterMappingNode, "url-pattern").getTextContent().trim());
			filterMapping.setDispatcher(getSingleChild(filterMappingNode, "dispatcher").getTextContent().trim());
			
			tagList.add(filterMapping);
		}
		
		NodeList listenerNodes = root.getElementsByTagName("listener");
		for(int i = 0;i< listenerNodes.getLength();i++){
			Listener listener = new Listener();
			listener.setName("listener");
			
			Element listenerNode = (Element) listenerNodes.item(i);
			listener.setListenerClass(getSingleChild(listenerNode, "listener-class").getTextContent().trim());
			tagList.add(listener);
		}
		
		NodeList servletNodes = root.getElementsByTagName("servlet");
		for(int i = 0;i<servletNodes.getLength();i++){
			Servlet servlet = new Servlet();
			servlet.setName("servlet");
			
			Element servletNode = (Element) servletNodes.item(i);
			servlet.setServletName(getSingleChild(servletNode, "servlet-name").getTextContent().trim());
			servlet.setServletClass(getSingleChild(servletNode, "servlet-class").getTextContent().trim());
			
			Element initParamNode = getSingleChild(servletNode, "init-param");
			if(initParamNode != null){
				InitParam initParam = new InitParam();
				initParam.setParamName(getSingleChild(initParamNode, "param-name").getTextContent().trim());
				initParam.setParamValue(getSingleChild(initParamNode, "param-value").getTextContent().trim());
				servlet.setInitParam(initParam);
			}
			tagList.add(servlet);
			}
		
		NodeList servletMappingNodes = root.getElementsByTagName("servlet-mapping");
		for(int i = 0;i<servletMappingNodes.getLength();i++){
			ServletMapping servletMapping = new ServletMapping();
			servletMapping.setName("servlet-mapping");
			
			Element servletMappingNode = (Element) servletMappingNodes.item(i);
			servletMapping.setServletName(getSingleChild(servletMappingNode, "servlet-name").getTextContent().trim());
			servletMapping.setUrlPattern(getSingleChild(servletMappingNode, "url-pattern").getTextContent().trim());
			
			tagList.add(servletMapping);
		}
		
		NodeList errorPageNodes = root.getElementsByTagName("error-page");
		for(int i = 0;i<errorPageNodes.getLength();i++){
			ErrorPage errorPage = new ErrorPage();
			errorPage.setName("error-page");
			
			Element errorPageNode = (Element) errorPageNodes.item(i);
			
			if(getSingleChild(errorPageNode, "exception-type") != null){
				errorPage.setExceptionType(getSingleChild(errorPageNode, "exception-type").getTextContent().trim());
			}
		
			if(getSingleChild(errorPageNode, "error-code") != null){
				errorPage.setErrorCode(getSingleChild(errorPageNode, "error-code").getTextContent().trim());
			}
			
			errorPage.setLocation(getSingleChild(errorPageNode, "location").getTextContent().trim());
			
			tagList.add(errorPage);
		}
		
		webApp = new WebApp();
		webApp.setName("/web-app");
		tagList.add(webApp);
	
		return tagList;
	}
	
	private static Element getSingleChild(Element element, String childName){
		NodeList nList = element.getElementsByTagName(childName);
		Element child = (Element)nList.item(0);
		return child;
	}
}
