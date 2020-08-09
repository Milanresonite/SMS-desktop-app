package com.milan;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Registration extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l,l9;
	JButton b1,b2,b0;
	Container c;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	JPasswordField pf1,pf2;
	JComboBox cb1,cb2;
	String s1,s2,s3="",s4="",s5,s6,s7,s8,pwd1,pwd2;
	
	
	
	public Registration() {
		
		c= getContentPane();
		c.setBackground(Color.pink);
		b0 = new JButton("HOME");
		l = new JLabel("Registration form");
		l1 = new JLabel("First Name:");
		l2 = new JLabel("Email id:");
		l3 = new JLabel("Enter new password:");
		l4 = new JLabel("Confirm password:");
		l5 = new JLabel("Mobile No.:");
		l6 = new JLabel("Country");
		l7 = new JLabel("State");
		l8 = new JLabel("City");
		l9 = new JLabel("More than 5 characters");
		
		String con[] = {"----SELECT YOUR COUNTRY----", "INDIA","PAK", "IRAN", "RUSSIA", "USA", "JAPAN","CHINA", "NEPAL" };
		cb1 = new JComboBox(con);
		String state[] = {"----SELECT YOUR STATE----","Delhi","Bihar","Punjab","UtterPradesh", "Goa","Bengal", "Kerela", "Gujrat", "Maharastra"};
		cb2 = new JComboBox(state);
		b1 = new JButton("Submit");
		b2 = new JButton("Reset");
		
		tf1 = new JTextField(); // name
		tf2 = new JTextField();  // Email
		tf3 = new JTextField();    // mob
		//tf4 = new JTextField();    // country
		//tf5 = new JTextField();   // state
		tf6 = new JTextField();     // city
		
		pf1 = new JPasswordField();
		pf2 = new JPasswordField();
		
		setVisible(true);
		setSize(800,1200);
		setResizable(false);
		setTitle("SMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l);
		add(b0);
		add(b1);
		add(b2);
		add(tf1);
		add(tf2);
		add(tf3);
		//add(tf4);
		//add(tf5);
		add(cb1);
		add(cb2);
		add(tf6);
		add(pf1);
		add(pf2);
	
		l.setBounds(300,30,400,40);
		l1.setBounds(100,100,150,30);
		l2.setBounds(100,150,150,30);
		l3.setBounds(100,200,150,30);
		l4.setBounds(100,250,150,30);
		l5.setBounds(100,300,150,30);
		l6.setBounds(100,350,150,30);
		l7.setBounds(100,400,150,30);
		l8.setBounds(100,450,150,30);
		
        tf1.setBounds(280,100,250,30);
        tf2.setBounds(280,150,250,30);
        pf1.setBounds(280,200,250,30);
        l9.setBounds(550,200,200,20);
        l9.setFont(new Font("serif",Font.ITALIC,12));
        l9.setForeground(Color.blue);
        pf2.setBounds(280,250,250,30);
        tf3.setBounds(280,300,250,30);
        /*tf4.setBounds(280,350,250,30);*/
        cb1.setBounds(280,350,250,30);
//        tf5.setBounds(280,400,250,30);
        cb2.setBounds(280,400,250,30);
        tf6.setBounds(280,450,250,30);
		
        b0.setBounds(20, 20, 80, 20);
        b1.setBounds(180,520,100,30);
        b2.setBounds(450,520,100,30);
        
        l.setForeground(Color.BLUE);
        l.setFont(new Font("serif",Font.BOLD,30));
        tf1.setToolTipText("Enter your First name");
        tf2.setToolTipText("Enter your Email id");
        pf1.setToolTipText("Create new password with lowerCase, uppercase and digit");
        pf2.setToolTipText("Enter password again to confirm");
        tf3.setToolTipText("Enter your 10 digit mobile no.");
       // tf4.setToolTipText("Enter country name");
       // tf5.setToolTipText("Enter your state name");
        tf6.setToolTipText("Enter your city name");
        
        b1.setToolTipText("click to Submit");
        b2.setToolTipText("click to clear all data");
        
        b1.addActionListener(this);
        b0.addActionListener(this);
        b2.addActionListener(this);
		
	}
	public boolean isValidEmail()
	{    boolean bool = false;
		if(tf2.getText().matches("[a-zA-Z0-9&&[^#$!~]]+"))
		   bool = true;
		   else 
			   bool = false;
		if(tf2.getText().contains("@"))
				bool = true;
		else
			bool = false;
		if(tf2.getText().contains("@@"))
			bool = false;
		if(tf2.getText().contains(".com"))
			bool = true;
		else
			bool = false;
		if(tf2.getText().contains(" "))
			bool = false;
			else 
				bool = true;
		
		return bool;
	}
	
	public boolean isvalidPassword()
	{
		boolean bool = false;
		if(Pattern.matches("[a-zA-Z0-9]{6,}", pf1.getText())) // X occurs 6 or more times
			{
			if(pf1.getText().matches("[0-9]+"))  // only digit contain
			{ bool = false; 
			System.out.println("jiii");
			 JOptionPane.showMessageDialog(pf1, "password only contains number", "password", JOptionPane.ERROR_MESSAGE);
			}
			else if(pf1.getText().matches("[a-z0-9]{6,}"))  // only digit and lowercase only
				{
				bool = false;
				JOptionPane.showMessageDialog(pf1, "password doesn't contain Upper case letter", "password", JOptionPane.ERROR_MESSAGE);
				}
			
			else if(pf1.getText().matches("[A-Z0-9]{6,}"))  // only digit and Uppercasecase only
			{
				bool = false;
				JOptionPane.showMessageDialog(pf1, "password doesn't contain Lower case letter", "password", JOptionPane.ERROR_MESSAGE);
				}
			
			
			else if(pf1.getText().matches("[a-zA-Z]{6,}"))  // only lowercase and Uppercasecase only
			{
				bool = false;
				JOptionPane.showMessageDialog(pf1, "password doesn't contain Number", "password", JOptionPane.ERROR_MESSAGE);
				}
			else
				bool=true;
			
			}
		else 
		{
			System.out.println("Hello pass else");
		   JOptionPane.showMessageDialog(pf1, "Enter a valid password", "password", JOptionPane.ERROR_MESSAGE);
		
		}
		return bool;
			
	}
	public boolean isValidMobile()
	{ // Accepts mobile no. starting from 6,7,8,9 and only 10 digit
		// mtd1  -->Pattern.matches("[6789]{1}[0-9]{9}", tf.getText()));//true  9+1=10
		// mtd 2 -->Pattern.matches("[6789][0-9]{9}", pf.getText()));//true 
		boolean bool = false;
	  if(Pattern.matches("[6789]{1}[0-9]{9}", tf3.getText()))
		  bool = true;
		  else
			  bool = false;
	  return bool;
	}
	
	@SuppressWarnings("deprecation")
	public boolean isEmp()
	{
		if(tf1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(tf1, "Please Enter your Name","user",JOptionPane.CLOSED_OPTION);
			return false;
		}
		else if(!(tf1.getText().matches("[a-zA-Z]{3,}"))) //X occurs 3 or more times
		{
			JOptionPane.showMessageDialog(tf1, "Enter a valid name", "user", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(tf2.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(tf2, "Please enter your Email id", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		else if(!isValidEmail())
		{
			JOptionPane.showMessageDialog(tf2, "Enter a valid email id", "hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(pf1.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(pf1, "Enter your password", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		
		else if(pf2.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(pf2, "Confirm your password", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		else if(!(isvalidPassword())) // galat ko sahi banakar use sahi banane ka tips(i.e. message) de rha hu
		{
			JOptionPane.showMessageDialog(pf1, "Enter a valid password", "Hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(tf3.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(tf3, "Enter your mobile number", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		else if(!(tf3.getText().matches("[0-9]+")))
		{
			JOptionPane.showMessageDialog(tf3, "Enter a Valid Mobile no.", "hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(!(isValidMobile()))
		{
			JOptionPane.showMessageDialog(tf3, "Enter a Valid Mobile no.", "hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		/*else if(tf4.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(tf4, "Enter your country name", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		else if(!(tf4.getText().matches("[a-zA-Z]{3,}")))
		{
			JOptionPane.showMessageDialog(tf4, "Enter a valid country name", "Hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if(tf5.getText().equals(""))
		{
			JOptionPane.showMessageDialog(tf5, "Enter your State name", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		else if(!(tf5.getText().matches("[a-zA-Z]{3,15}")))
		{
			JOptionPane.showMessageDialog(tf5, "enter a valid state name", "Hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}*/
		/*else if(!(tf5.getText().matches("[a-zA-Z]+")))
		{
			JOptionPane.showMessageDialog(tf5, "Only alphabets are allowed", "Hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}*/
		
		else if(cb1.getItemAt(cb1.getSelectedIndex()).equals("----SELECT YOUR COUNTRY----"))
		{
			
			JOptionPane.showMessageDialog(cb1, "Please select your Country", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		
		else if(cb2.getItemAt(cb2.getSelectedIndex()).equals("----SELECT YOUR STATE----"))
		{
			
			JOptionPane.showMessageDialog(cb2, "Please select your State", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		
		
		else if(tf6.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(tf6, "Enter your City name", "Hello "+(tf1.getText()), JOptionPane.CANCEL_OPTION);
			return false;
		}
		else if(!(tf6.getText().matches("[a-zA-Z]{3,}")))
		{
			JOptionPane.showMessageDialog(tf6, "Enter a valid city name", "Hello "+(tf1.getText()), JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else 
		 return true;
		
	}
	
	 public void actionPerformed(ActionEvent e) {
		 
		 if(e.getSource()==b0)
			{
			Registration.this.dispose();
			new HomePage();
			}
			if(e.getSource()==b1)
			{
				
				boolean bool = isEmp();
				//boolean bool2 = isExists(DbMob,DbEmail);
				try
				{
					Connection con = ConnectionProvider.getConnection();				
					Statement st = con.createStatement();
					ResultSet  rs = st.executeQuery("select * from clients");
					  
					  while(rs.next())
					  {
						  if(rs.getString("email").equals(tf2.getText()))
						  {
							  JOptionPane.showMessageDialog(tf2, "Email id already exists", "Error", JOptionPane.ERROR_MESSAGE);
							  bool = false;
						  }
						  else if( rs.getString("phone").equals(tf3.getText()))
						  {
							  JOptionPane.showMessageDialog(tf3, "Mobile no. already exists", "Error", JOptionPane.ERROR_MESSAGE);
							  bool = false;
						  }
					  }
					    
				}
				catch(Exception e5)
				{
					System.out.println(e5);
				}
				
				if(bool)
				{
					 s1 = tf1.getText().toUpperCase();
					   s2 = tf2.getText();
					   char ch1[]= pf1.getPassword();
					   char ch2[] = pf2.getPassword();
					   for(int i=0;i<ch1.length;i++)
						   s3 = s3 + String.valueOf(ch1[i]) ;
					   
					   for(int i=0;i<ch2.length;i++)
						   s4 = s4 + String.valueOf(ch2[i]) ;
					   pwd1 = new String(s3);
					   pwd2 = new String(s4);
					   
					   s5 = tf3.getText().toUpperCase();
					 //  s6 = tf4.getText().toUpperCase();
					   s6 = (String) cb1.getItemAt(cb1.getSelectedIndex());
					   s7 = (String) cb2.getItemAt(cb2.getSelectedIndex());
					  // s7 = tf5.getText().toUpperCase();
					   s8 = tf6.getText().toUpperCase();
			
				
		  if(pwd1.equals(pwd2))
		  {		
				try
				{
					Connection con = ConnectionProvider.getConnection();				
					Statement st = con.createStatement();
					//st.executeUpdate("create table clients(Name varchar(15), email varchar(30), pass1 varchar(20), pass2 varchar(20), phone varchar(10), country varchar(15), state varchar(10), city varchar(10))");
				   // System.out.println(" Table created");
				  //st.executeUpdate("insert into clients values('Ravi', 'rk@gmail.com', '1234' , '1236', '123456789', 'India', 'Bihar', 'katihar')");
					String query = "insert into clients values(?,?,?,?,?,?,?,?)";
				    PreparedStatement ps = con.prepareStatement(query);
				   
				    
				    ps.setString(1,s1);
				    ps.setString(2, s2);
				    ps.setString(3, pwd1);
				    ps.setString(4, pwd2);
				    ps.setString(5, s5);
				    ps.setString(6, s6);
				    ps.setString(7, s7);
				    ps.setString(8, s8);
				      
				    ps.executeUpdate();
				    con.close();
				    st.close();
				    
				    
				    int x1 = JOptionPane.showConfirmDialog(this,"Do you want to Login","Success", JOptionPane.YES_NO_CANCEL_OPTION);
				    if(x1==JOptionPane.YES_OPTION)
				    {
				    	Registration.this.dispose();
				    	new Login();
				    }
				    else if(x1==JOptionPane.NO_OPTION)
				    {
				    	System.exit(0);
				    }
				    	
				    
				}
				catch(Exception e4)
				{ System.out.println(e4);}
				
			}
		
		  else if(!(pwd1.equals(pwd2)))
			{
				JOptionPane.showMessageDialog(pf2, "password doesn't match", "Hello "+s1, JOptionPane.ERROR_MESSAGE);
			}
		}
	}
			else
			{
				tf1.setText("");
				pf1.setText("");
				pf2.setText("");
				tf2.setText("");
				tf3.setText("");
				tf4.setText("");
				tf5.setText("");
				tf6.setText("");		
			}
		}

	public static void main(String[] args) {
		new Registration();
	}
}
