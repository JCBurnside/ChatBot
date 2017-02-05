package com.github.jcburnside.ChatBot;

import org.atteo.classindex.ClassIndex;

import com.github.jcburnside.ChatBot.Utils.Bot;

public class Main {
	public Main(){
	}
	public static void main(String[] args) {
		//TODO add profile loader as well as defualt profile location w/ universal support
		for(Class<?>c:ClassIndex.getAnnotated(Bot.class))
			System.out.println(c.getName());
	}

}
