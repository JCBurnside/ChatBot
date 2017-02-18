package com.github.jcburnside.ChatBot;

public abstract class ChatHandler {
	/*
	 * @param msg: string you wish bot to say in chat
	 */
	public abstract void send(String msg);
	/*
	 * @param usr: username of the user you wish to ban
	 * @param reason: reason for ban
	 */
	public abstract void ban(String usr,String reason);
	/*
	 * @param usr: username of the user you wish to timeout
	 * @param reason: reason for timeout
	 */
	public abstract void timeout(String usr,String reason);
	/*
	 * @param usr: username of the user you wish to purge
	 * @param reason: reason for timeout
	 */
	public abstract void purge(String usr,String reason);
	/*
	 * @param usr: username of the user you wish to purge
	 * @param reason: reason for purge
	 */
	public abstract void purge(String usr,String reason,boolean timeout);
	/*
	 * 
	 */
	public void handle(String msg){
		
	}
}
