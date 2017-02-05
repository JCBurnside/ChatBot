package com.github.jcburnside.ChatBot;
import com.github.jcburnside.ChatBot.ChatHandler;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jibble.pircbot.PircBot;
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
		layout.addLayoutComponent(loginBtn, constraints);
		constraints.gridy=3;
		constraints.gridheight=4;
		layout.addLayoutComponent(scroll, constraints);
		constraints.gridy=7;
		constraints.gridheight=1;
		layout.addLayoutComponent(input, constraints);
		constraints.gridx=4;
		layout.addLayoutComponent(sendBtn, constraints);
		usrLbl=new JLabel("Username:");
		panel.add(usrLbl);
		passLbl=new JLabel("Password:");
		panel.add(passLbl);
		usrField=new JTextField("Username");
		panel.add(usrField);
		passField=new JPasswordField("Password");
		panel.add(passField);
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
