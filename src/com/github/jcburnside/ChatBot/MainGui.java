package com.github.jcburnside.ChatBot;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JPanel;

public class MainGui {
	private JPanel connections;//will hold check boxes of all the avaible types of bots.
	private HashMap<String,BotBase> bots;
	private HashMap<String,JPanel> displayedBots;//this will be used within a JScrollPane to controll bot JPanels and remove unused ones.
	@SafeVarargs
	public MainGui(Class<? extends BotBase>...classes ){
		for(Class<? extends BotBase> t:classes){
			try{
				BotBase botB=(BotBase) t.getConstructors()[0].newInstance((Object[])null);
				bots.put(botB.title, botB);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
