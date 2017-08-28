package com.github.jcburnside.ChatBot.Services;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import com.github.jcburnside.ChatBot.BotBase;
import com.github.jcburnside.ChatBot.ChatHandler;
import com.github.jcburnside.ChatBot.Utils.Consts;
import com.github.jcburnside.ChatBot.Utils.ScriptableFunction;
@ScriptableFunction(For="Twitch")
class TwitchHandler extends ChatHandler{
	private Twitch chat;
	private String channel;
	public TwitchHandler(Twitch twitch){
		chat=twitch;
		channel=chat.getName();
	}
	public TwitchHandler(Twitch twitch,String _channel){
		chat=twitch;
		channel=_channel;
	}
	@Override
	public void send(String msg) {
		// TODO Auto-generated method stub
		chat.sendMessage(channel, msg);
	}

	@Override
	public void ban(String usr, String reason) {
		send("/ban "+usr);
		send(usr+" has been banned permanantly for "+reason);
	}
	
	@Override
	public void timeout(String usr, String reason) {
		send("/timeout "+usr);
		send(usr+" has been timedout for 10 mintues for "+reason);
	}
	@Override
	public void timeout(String usr, String reason, long time) {
		send("/timeout "+usr+" "+time);
		send(usr+" has been timed out for "+convertToMinutes(time));
	}
	@Override
	public void purge(String usr, String reason) {
		purge(usr,reason,1);
	}

	@Override
	public void purge(String usr, String reason, long timeout) {
		//timeouts work as a clearchat command for users.
		timeout(usr,reason,timeout);
	}
	@Override
	public void handle(String msg){
		if(msg.startsWith("PING"))
			send(msg.split(" ")[1]);
		else
			super.handle(msg);
	}
	
}
public class Twitch extends BotBase {
	private JLabel OAuthLbl=new JLabel("OAUTH");
	private JTextField OAuthField=new JTextField();
	public Twitch() {
		super("Twitch");
		
	}
	@Override
	public JPanel getPanel(){
		System.out.println("IN TWITCH PANEL");
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(title));
		usrLbl=new JLabel("Username:");
		panel.add(usrLbl);
		passLbl=new JLabel("Password:");
		panel.add(passLbl);
		usrField=new JTextField("Username");
		panel.add(usrField);
		passField=new JPasswordField("Password");
		panel.add(passField);
		scroll=new JScrollPane();
		chatArea=new JTextArea();
		chatArea.setLineWrap(true);
		chatArea.setAutoscrolls(true);
		chatArea.setEditable(false);
		scroll.setViewportView(chatArea);
		panel.add(scroll);
		input=new JTextField();
		input.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				chat.send(input.getText());
				input.setText("");
			}
		});
		input.setEnabled(false);
		panel.add(input);
		sendBtn=new JButton("Send");
		sendBtn.setEnabled(false);
		panel.add(sendBtn);
		loginBtn=new JButton("Login");
		loginBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loginBtn.getText()=="Login"){
					login();
				}else if(loginBtn.getText()=="Logoff"){
					logoff();
				}
			}
		});
		panel.add(loginBtn);
		GridBagLayout layout=new GridBagLayout();
		GridBagConstraints constraints=new GridBagConstraints();
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.ipadx=1;
		constraints.ipady=1;

		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.gridx=0;
		constraints.gridy=0;
		layout.addLayoutComponent(usrLbl, constraints);
		constraints.gridx=1;
		constraints.gridwidth=3;
		layout.addLayoutComponent(usrField, constraints);
		constraints.gridy=1;
		layout.addLayoutComponent(passField, constraints);
		constraints.gridx=0;
		constraints.gridwidth=1;
		layout.addLayoutComponent(passLbl, constraints);
		constraints.gridy=2;
		layout.addLayoutComponent(OAuthLbl, constraints);
		constraints.gridx=1;
		layout.addLayoutComponent(OAuthField, constraints);
		constraints.gridx=0;
		constraints.gridy=3;
		layout.addLayoutComponent(loginBtn, constraints);
		
		constraints.gridy=7;
		constraints.gridheight=1;
		layout.addLayoutComponent(input, constraints);
		constraints.gridx=4;
		layout.addLayoutComponent(sendBtn, constraints);
		constraints.gridx=0;
		constraints.gridy=4;
		constraints.gridheight=4;
		constraints.weightx=1;
		constraints.weighty=1;
		layout.addLayoutComponent(scroll, constraints);
		panel.setLayout(layout);

		return panel;
	}
	@Override
	protected void login() {
		String usr=usrField.getText();
		String pass=new String(passField.getPassword());
		String Oauth=OAuthField.getText();
		try {
			this.setName(usr.toLowerCase());
			this.connect("irc.twitch.tv", 6667, Oauth);
		} catch (NickAlreadyInUseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IrcException e) {
			e.printStackTrace();
		}
		chat=new TwitchHandler(this);
		chat.send("I am alive and am using version "+Consts.version);
	}

	@Override
	protected void logoff() {
		if(this.isConnected())
			this.disconnect();
	}

}
