package by.asushenya.saxp.controller.command;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.asushenya.saxp.bean.behaviour.Tag;
import by.asushenya.saxp.service.impl.StAXProcess;

public class StAXParser implements Parser{
	
	@Override
	public List<Tag> parse(String fileName) throws XMLStreamException, 
												   FileNotFoundException{
		List<Tag> tagList = null;
			
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();			
			InputStream input = new FileInputStream(fileName);
			XMLStreamReader staxReader = inputFactory.createXMLStreamReader(input);
			tagList = StAXProcess.process(staxReader);
				
		return tagList;
	}
}
