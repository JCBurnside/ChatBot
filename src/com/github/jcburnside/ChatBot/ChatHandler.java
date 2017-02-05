package com.github.jcburnside.ChatBot;

public interface ChatHandler {
	public void send(String msg);
	public void ban(String usr,String reason);
	public void timeout(String usr,String reason);
	public void purge(String usr,String reason);
	public void purge(String usr,String reason,boolean timeout);
}
