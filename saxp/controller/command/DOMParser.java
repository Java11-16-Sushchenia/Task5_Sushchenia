package by.asushenya.saxp.controller.command;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import by.asushenya.saxp.bean.behaviour.Tag;
import by.asushenya.saxp.service.impl.DOMWebXMLParser;


public class DOMParser implements Parser{
	
	@Override
	public List<Tag> parse(String fileName) throws SAXException, IOException {
		
		List<Tag> tagList = null;	
					
		tagList = DOMWebXMLParser.getTagList(fileName);
					
	return tagList;
	}
}
