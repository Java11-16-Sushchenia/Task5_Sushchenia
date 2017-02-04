package by.asushenya.saxp.util;

public enum WebXMLTagName {
	WEB_APP,
	DISPLAY_NAME, 
	
	WELCOME_FILE_LIST, 		WELCOME_FILE, 
	FILTER, 				FILTER_NAME, FILTER_CLASS,
	INIT_PARAM,			    PARAM_NAME, PARAM_VALUE,
	FILTER_MAPPING, 		URL_PATTERN, DISPATCHER, 
	LISTENER, 				LISTENER_CLASS,
	SERVLET, 				SERVLET_NAME, SERVLET_CLASS, 
	SERVLET_MAPPING,
	ERROR_PAGE, 			EXCEPTION_TYPE, LOCATION, ERROR_CODE;
	
	public static WebXMLTagName getElementTagName(String element){
		WebXMLTagName elementName = null;
					
		elementName = WebXMLTagName.valueOf(element.toUpperCase().replace("-", "_"));
			
		return elementName;
	}
}
