package com.github.jcburnside.ChatBot;
import com.github.jcburnside.ChatBot.ChatHandler;
public abstract class BotBase {
	public ChatHandler chat;
	String username;
	public Thread chatStream;
}
