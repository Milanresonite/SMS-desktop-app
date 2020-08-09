package com.milan;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage extends JFrame{

	JLabel l1;
	JButton b1,b2;
	Container c;
	HomePage()
	{
		b1 = new JButton("LOGIN");
		b2 = new JButton("CREATE A NEW ACCOUNT");
		l1 = new JLabel("    WELCOME TO SMS");
		c = getContentPane();
		
		setVisible(true);
		setSize(600,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SMS");
		
		setLayout(null);
		c.setBackground(Color.pink);
		l1.setBounds(100,50,400,40);
		l1.setFont(new Font("serif",Font.BOLD,30));
		l1.setForeground(Color.RED);
	    b1.setBounds(250,250,100,40);
	    b1.setFont(new Font("serif",Font.PLAIN,20));
	    b1.setForeground(Color.BLUE);
	    
	    b2.setBounds(150,350,300,40);
	    b2.setFont(new Font("serif",Font.PLAIN,20));
	    b2.setForeground(Color.BLUE);
	    
	    add(l1);
	    add(b1);
	    add(b2);
	    
	    b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
	    			HomePage.this.dispose();
		    		new Registration();
			}
		});
	    b1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e)
	    	{
		    		HomePage.this.dispose();
		    		new Login();
	    		}
	    });
	
	}
	public static void main(String[] args) {
		new HomePage();
	}
}
