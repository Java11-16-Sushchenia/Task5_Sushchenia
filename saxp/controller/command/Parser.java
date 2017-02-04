package by.asushenya.saxp.controller.command;

import java.io.IOException;
import java.util.List;

import javax.xml.stream.XMLStreamException;

import org.xml.sax.SAXException;

import  by.asushenya.saxp.bean.behaviour.Tag;



public interface Parser {
	List<Tag> parse(String fileName) throws SAXException,
											IOException,
											XMLStreamException;
}
