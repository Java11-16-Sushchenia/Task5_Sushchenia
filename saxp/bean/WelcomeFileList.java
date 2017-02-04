package by.asushenya.saxp.bean;

import by.asushenya.saxp.bean.behaviour.Tag;

import java.util.List;
import java.util.ArrayList;

public class WelcomeFileList extends Tag{
	private List<String> welcomeFiles = new ArrayList<String>();
	
	public WelcomeFileList(){}
	
	public void addWelcomeFile(String welcomeFile){
		welcomeFiles.add(welcomeFile);
	}
	public List<String> getWelcomeFiles(){
		return welcomeFiles;
	}
	
	@Override
	public void showTag(){
		System.out.println("<"+super.getName()+">");
		for(String file: welcomeFiles){
			
			System.out.println("\t\t<welcome-file>"+file+"</welcome-file>");
		}
		System.out.println("</"+super.getName()+">");
	}
	
	
	
	
}
