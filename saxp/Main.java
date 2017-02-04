package by.asushenya.saxp;

import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import java.io.IOException;

import by.asushenya.saxp.bean.behaviour.Tag;

import by.asushenya.saxp.controller.Controller;

import by.asushenya.saxp.util.ParserName;


public class Main {

	public static void main(String[] args){
		
				
		Controller controller = new Controller();	
		
		String fileName =  "src/by/asushenya/saxp/resource/webxml/WebApp.xml";
				
		List<Tag> tagList = null;
		
		try {
			tagList = controller.getTagList(ParserName.SAX, fileName);
			
		} catch (IOException e) {
						e.printStackTrace();
		} catch (SAXException e) {
						e.printStackTrace();
		} catch (XMLStreamException e) {
						e.printStackTrace();
		}
		
		for(Tag item:tagList)
		{
			item.showTag();
		}		
	}
}
