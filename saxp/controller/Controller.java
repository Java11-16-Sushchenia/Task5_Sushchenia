package by.asushenya.saxp.controller;

import by.asushenya.saxp.bean.behaviour.Tag;

import by.asushenya.saxp.controller.command.Parser;

import by.asushenya.saxp.util.ParserName;
import by.asushenya.saxp.controller.ParserProvider;

import java.io.IOException;

import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;


public class Controller {
	
	private final ParserProvider provider = new ParserProvider();
		
	public List<Tag> getTagList(ParserName parserName, String fileName)
					 throws IOException, SAXException, XMLStreamException{
		
		List<Tag> tagList = null;
		
		Parser parser = provider.getParser(parserName);
		tagList = parser.parse(fileName);
		
		return tagList;
	}
	
	
}
