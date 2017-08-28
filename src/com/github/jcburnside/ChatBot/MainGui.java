package com.github.jcburnside.ChatBot;

import java.awt.event.KeyEvent;
import java.io.Console;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainGui extends JFrame {
	private JPanel connections;//will hold check boxes of all the avaible types of bots.
	private JPanel display;
	private JTabbedPane Tabs=new JTabbedPane();
	private HashMap<String, BotBase> bots=new HashMap<String,BotBase>();
	private HashMap<String,JPanel> displayedBots;//this will be used within a JScrollPane to controll bot JPanels and remove unused ones.
	@SafeVarargs
	public MainGui(Class...classes ){
		super("TESTING");
		String s="";
		display=new JPanel();
		System.out.println(classes.length);
		int ctr=0;
		for(Class<? extends BotBase> t:classes){
			try{
				System.out.println(t);
				BotBase botB=(BotBase) t.getConstructors()[0].newInstance(new Object[] {});
				bots.put(botB.title, botB);
				Tabs.add(botB.title,botB.getPanel());
				if(ctr<=9){
					Tabs.setMnemonicAt(ctr, ctr);
				}
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
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
			} catch(Error e){
				e.printStackTrace();
			}
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(Tabs);
		setSize(400,400);
		setVisible(true);
		pack();
	}
	
}
