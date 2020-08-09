package com.milan;

import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.sql.*;

import java.awt.*;

public class Login extends JFrame implements ActionListener {
	JLabel l1,l2,l3,l;
	JButton b0,b1,b2,b3;
	JTextField tf;
	JPasswordField pf;
	Container c;
	
	Login()
	{
		c = getContentPane();
		c.setBackground(Color.pink);
		l = new JLabel("Member login");
		l1 = new JLabel("Email id:");
		l2 = new JLabel("Password:");
		l3 = new JLabel("or");
		
		b0 = new JButton("HOME");
		b1 = new JButton("Log In");
		b2 = new JButton("Quit");
		b3 = new JButton("Sign Up");
		
		tf = new JTextField();
		pf = new JPasswordField();
		
		setVisible(true);
		setBounds(400,200,700,500);
		setTitle("SMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		add(l1);
		add(l2);
		add(l3);
		add(l);
		add(b0);
		add(b1);
		add(b2);
		add(b3);
		add(tf);
		add(pf);
		
		b0.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		b0.setBounds(20, 20, 80, 20);
		l.setBounds(250, 50, 300, 40);
		l.setFont(new Font("serif",Font.BOLD,30));
		l.setForeground(Color.RED);
		l1.setBounds(100, 150, 150, 30);
		l1.setFont(new Font("serif",Font.PLAIN,20));
		l2.setBounds(100, 200, 150, 20);
		l2.setFont(new Font("serif",Font.PLAIN,20));
		tf.setBounds(250, 150, 200, 30);
		tf.setToolTipText("Enter your registered email id");
		pf.setBounds(250, 200, 200, 30);
		pf.setToolTipText("Enter your password");
		b1.setBounds(200, 270, 80, 20);
		b2.setBounds(400,270,80,20);
		
		b3.setBounds(300,320,100,20);
		
	}
	
	public boolean isEmpty()
	{
		if(tf.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tf, "Please Enter your Email","user",JOptionPane.CLOSED_OPTION);
			return false;
		}
		else if(pf.getText().equals(""))
		{
			JOptionPane.showMessageDialog(pf, "Enter your password", "Hello ", JOptionPane.CANCEL_OPTION);
			return false;
		}
		else 
			return true;
	}	
	
		public static void main(String[] args) {
		// new Login();
	}

	@Override
	public void actionPerformed(java.awt.event.ActionEvent e) { //Use actionPerformed at the last of your class
		// TODO Auto-generated method stub
		if(e.getSource()==b0)
		{
		Login.this.dispose();
		new HomePage();
		}
		else if(e.getSource()==b2)
		{
			System.exit(0);
		}
		else if(e.getSource()==b3)
		{
			Login.this.dispose();
			new Registration();
		}
	   else if(e.getSource()==b1)
		{
			boolean bool = isEmpty();
			if(bool)
			{
				try
				{
					String user = tf.getText();
					String pwd = pf.getText();
					Connection con = ConnectionProvider.getConnection();
					Statement st = con.createStatement();
					ResultSet rs3 = st.executeQuery("select * from clients");
					boolean t = false;
					
					while(rs3.next())
					{
					if(rs3.getString("email").equals(user) && rs3.getString("pass1").equals(pwd)) 
					{   t=true;
						break;
					}
					}
					if(t)
						{
						JOptionPane.showMessageDialog(tf, "Login Successful");
						Login.this.dispose();
						new Home2();
						
						}
					else
						{
						JOptionPane.showMessageDialog(tf, "Username or Password Invalid","user" ,JOptionPane.ERROR_MESSAGE);
						System.out.println("username / password Invalid");
						}
					con.close();
					st.close();
					rs3.close();
				}
				catch(Exception e1)
				{
					System.out.println(e1);
				}
			}
		}
	}
	
}
