package com.github.jcburnside.ChatBot;
import com.github.jcburnside.ChatBot.ChatHandler;
import com.github.jcburnside.ChatBot.Utils.Bot;
import com.github.jcburnside.ChatBot.Utils.GBC;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jibble.pircbot.PircBot;
@Bot
public abstract class BotBase extends PircBot{
	public ChatHandler chat;
	protected String title="";
	protected JTextField usrField,input;
	protected JTextArea chatArea;
	protected JButton sendBtn,loginBtn;
	protected JPasswordField passField;
	protected JScrollPane scroll;
	protected JLabel usrLbl,passLbl;
	protected abstract void login();
	protected abstract void logoff();
	public JPanel getPanel(){
		System.out.println("IN BASE PANEL");
		
		JPanel panel=new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setAlignmentX(JPanel.LEFT_ALIGNMENT);
		panel.setAlignmentY(JPanel.TOP_ALIGNMENT);
		
		usrLbl=new JLabel("Username:");
		panel.add(usrLbl, 
				new GBC(0,0)
				.setInsets(5)
				.setAnchor(GBC.NORTHWEST));
		usrField=new JTextField("Username");
		panel.add(usrField,
				new GBC(1,0)
				.setFill(GBC.HORIZONTAL)
				.setSpan(3, 1));
		passLbl=new JLabel("Password:");
		panel.add(passLbl,
				new GBC(0,1)
				.setInsets(5));
		passField=new JPasswordField("Password");
		panel.add(passField,
				new GBC(1,1)
				.setFill(GBC.HORIZONTAL)
				.setSpan(3,1));
		scroll=new JScrollPane();
		chatArea=new JTextArea();
		chatArea.setLineWrap(true);
		chatArea.setAutoscrolls(true);
		chatArea.setEditable(false);
		scroll.setViewportView(chatArea);
//		panel.add(scroll);
		input=new JTextField();
		input.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				chat.send(input.getText());
				input.setText("");
			}
		});
		input.setEnabled(false);
//		panel.add(input);
		sendBtn=new JButton("Send");
		sendBtn.setEnabled(false);
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
//		panel.add(sendBtn);
		panel.setMinimumSize(panel.getPreferredSize());;
		panel.setBorder(BorderFactory.createTitledBorder(title));
		return panel;
	}
	
	protected void onMessage(String Channel,String sender,String login,String hostName,String msg){
		chat.handle(msg);
		chatArea.append(String.format("[%s]%s", sender,msg));
	}
	public BotBase(String title){
		this.title=title;
	}
}
