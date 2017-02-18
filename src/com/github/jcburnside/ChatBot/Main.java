package com.github.jcburnside.ChatBot;

import java.util.HashSet;

import org.atteo.classindex.ClassIndex;

import com.github.jcburnside.ChatBot.Utils.Bot;

public class Main {
	public static void main(String[] args) {
		//TODO add profile loader as well as defualt profile location w/ universal support
		HashSet<Class<? extends BotBase>> LoadableBots = new HashSet<Class<? extends BotBase>>();
		for(Class<?>c:ClassIndex.getAnnotated(Bot.class)){
			System.out.println("Loading "+c.getName()+" into que");
			if(c.getSuperclass()!=BotBase.class){
				System.out.println(c.getName()+" is not sub-class of BotBase and shall not be loaded.");
				continue;
			}
			LoadableBots.add((Class<? extends BotBase>) c);
		}
	}
}
