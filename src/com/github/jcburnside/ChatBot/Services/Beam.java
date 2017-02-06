package com.github.jcburnside.ChatBot.Services;
import com.github.jcburnside.ChatBot.BotBase;
import com.github.jcburnside.ChatBot.ChatHandler;
import com.github.jcburnside.ChatBot.Utils.Bot;
import com.github.jcburnside.ChatBot.Utils.ScriptableFunction;
public class Beam extends BotBase{

	public Beam(String title) {
		super(title);
		chat=new BeamChat();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void login() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void logoff() {
		// TODO Auto-generated method stub

	}
}
@ScriptableFunction(For="Beam")
class BeamChat extends ChatHandler{

	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void ban(String usr, String reason) {
		// TODO Auto-generated method stub

	}

	@Override
	public void timeout(String usr, String reason) {
		// TODO Auto-generated method stub

	}

	@Override
	public void purge(String usr, String reason) {
		// TODO Auto-generated method stub

	}

	@Override
	public void purge(String usr, String reason, boolean timeout) {
		// TODO Auto-generated method stub

	}
}