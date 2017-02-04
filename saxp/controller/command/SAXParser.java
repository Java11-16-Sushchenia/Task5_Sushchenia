package by.asushenya.saxp.controller.command;

import java.io.IOException;
import java.util.List;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import by.asushenya.saxp.bean.behaviour.Tag;
import by.asushenya.saxp.service.impl.WebXMLSAXHandler;


public class SAXParser implements Parser{
	@Override
	public List<Tag> parse(String fileName) throws SAXException, IOException {
		List<Tag> tagList = null;
		
			XMLReader saxReader = XMLReaderFactory.createXMLReader();		
			WebXMLSAXHandler handler = new WebXMLSAXHandler();
			saxReader.setContentHandler(handler);
			saxReader.parse(new InputSource(fileName));
			
			tagList = handler.getTagList();
				
		return tagList;
	}
}
