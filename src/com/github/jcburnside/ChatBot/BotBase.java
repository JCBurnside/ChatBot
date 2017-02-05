package com.github.jcburnside.ChatBot;
import com.github.jcburnside.ChatBot.ChatHandler;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;
public abstract class BotBase {
	public ChatHandler chat;
	protected String title="";
	public Thread chatStream;
	protected JTextField usrField;
	protected JButton sendBtn,loginBtn;
	protected JPasswordField passField;
	protected JScrollPane scroll;
	protected JLabel usrLbl,passLbl;
	protected abstract void login(); 
	public JPanel getPanel(){
		JPanel panel=new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder(title));
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
		constraints.gridwidth=4;
		layout.addLayoutComponent(loginBtn, constraints);
		constraints.gridy=3;
		constraints.gridheight=4;
		//TODO figure out how to make a scroll pane/JTextArea respond to thread changes.
		return null;
	}
}
