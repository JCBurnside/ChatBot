package com.github.jcburnside.ChatBot.Utils;

import java.util.ArrayList;

public class SongrequestHandler {
	protected boolean enabled=false;
	protected ArrayList<Song> que=new ArrayList<Song>();
	//ease of scripting functions used to enable/disable the song request feature.  
	@ScriptableFunction
	public void Enable(){
		enabled=true;
	}
	@ScriptableFunction
	public void Disable(){
		enabled=false;
	}
	@ScriptableFunction
	public void AddSong(String arg){
		if(enabled){
			if(arg.contains("youtube.com")||arg.contains("youtu.be")){
				
			}
		}
	}
	public void AddSong(String service,String url){
		if(enabled){
			//test
		}
	}
	public SongrequestHandler(){
		
	}
	//unified object for ease of play
	private class Song{
		public String Title;
		public String URL;
		public String Service;
	}
}
