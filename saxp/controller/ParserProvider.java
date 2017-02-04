package by.asushenya.saxp.controller;

import by.asushenya.saxp.util.ParserName;
import by.asushenya.saxp.controller.command.Parser;

import by.asushenya.saxp.controller.command.SAXParser;
import by.asushenya.saxp.controller.command.StAXParser;
import by.asushenya.saxp.controller.command.DOMParser;

import java.util.Map;
import java.util.HashMap;

public class ParserProvider {
	
	private final Map<ParserName, Parser> repository = new HashMap<>();
	
	ParserProvider(){
		repository.put(ParserName.SAX,  new SAXParser());
		repository.put(ParserName.StAX, new StAXParser());
		repository.put(ParserName.DOM,  new DOMParser());
	}
	
	Parser getParser(ParserName parserName){
		Parser parser = null;		
		parser = repository.get(parserName);
		
		return parser;
	}
}
