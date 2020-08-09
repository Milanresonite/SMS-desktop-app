package com.milan;
import java.awt.Color;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Home2 extends JFrame implements ItemListener, ActionListener{

	JLabel l1,l2,l3;
	JRadioButton rb1,rb2,rb3;
	JButton b1,b2,b3;
	Container c;
	JTextField tf;
	public Home2() {
		c = getContentPane();
		c.setBackground(Color.pink);
		l1 = new JLabel("Sweet shop");
		l2 = new JLabel("Choose action");
		l3 = new JLabel();
		rb1 = new JRadioButton("  Add Raw materials");
		rb2 = new JRadioButton("  Display raw materials");
		rb3 = new JRadioButton("  Make Sweets");
		b1 = new JButton("Log Out");
		b2 = new JButton("Click to procced");
		b3 = new JButton("Quit");
		tf = new JTextField();
		ButtonGroup bg=new ButtonGroup(); 
		
		
		setVisible(true);
		setResizable(false);
		setBounds(400,200,700,550);
		setTitle("SMS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		add(b1);
		add(b2);
		add(l1);
		add(b3);
		add(l2);
		add(rb1);
		add(rb2);
		add(rb3);
		add(l3);
		add(tf);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		b1.setBounds(550,30,80,30);
		l1.setBounds(250,80,400,40);
		l1.setFont(new Font("serif",Font.BOLD,30));
		l1.setForeground(Color.blue);
		l2.setBounds(110,130,200,20);
		l2.setFont(new Font("serif",Font.ITALIC,18));
		l2.setForeground(Color.black);
		rb1.setBackground(Color.yellow);
		rb2.setBackground(Color.yellow);
		rb3.setBackground(Color.yellow);
		
		rb1.setBounds(100,170,400,30);
		rb2.setBounds(100,220,400,30);
		rb3.setBounds(100,270,400,30);
		
		l3.setBounds(110,310,200,30);
		l3.setForeground(Color.red);
		tf.setBounds(315,310,40,30);
		tf.setEditable(false);tf.setBackground(Color.pink);
		b2.setBounds(80, 420, 200, 30);
		b3.setBounds(380, 420, 100, 30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		
		
		
	}
	public static void main(String[] args) {
		new Home2();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
	   if(rb3.isSelected())
	   {
		   l3.setText("Enter amount what you want (Kg)");
		   tf.setEditable(true);
		   tf.setBackground(Color.WHITE);
	   }
		   
		
	}
	public void actionPerformed(ActionEvent e)
	{  
		double ml=0.0,sg=0.0,kh=0.0;
		
		
		
		
		if(e.getSource()==b2 )
		{  
			try {
				Connection cn = ConnectionProvider.getConnection();
				Statement st = cn.createStatement();
				
				ResultSet rs = st.executeQuery("select * from rawmaterial");
				rs.next(); // Return true and move one row down
				System.out.println(1);
				 ml = rs.getDouble(1);
				 sg = rs.getDouble(2);
				 kh = rs.getDouble(3);
			
			
			if(rb1.isSelected())
			{
				Home2.this.dispose();
				new AddMaterial();
			}
			else if(rb2.isSelected())
			{
				JOptionPane.showMessageDialog(rb2, "Milk:"+ml+" Ltr  Sugar:"+sg+" Kg   Khoya:"+kh+" Kg", "Current Stock", JOptionPane.INFORMATION_MESSAGE);
				System.out.println("2nd is selected");
				
			}
			else if(rb3.isSelected())
			{
				double sweet = Double.parseDouble(tf.getText());
				double ReqMilk = sweet*2, ReqSugar = sweet/2 , ReqKhoya = sweet/4 ;
				if(isSufficient(sweet, ReqMilk, ReqSugar, ReqKhoya, ml, sg, kh))
				{
					PreparedStatement ps = cn.prepareStatement("update rawmaterial set MILK="+(ml-ReqMilk)+", SUGAR="+(sg-ReqSugar)+", KHOYA="+(kh-ReqKhoya)+" ");
					ps.executeUpdate();
					JOptionPane.showMessageDialog(rb3, ""+sweet+" Kg product has been made successfully");
				}
				
			}
			else if(!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected())
			{
				JOptionPane.showMessageDialog(null,"Please select an option");	
			}
			}
			catch(Exception er)
			{
				System.out.println(er);
			}
		}
		else if(e.getSource()==b1)
		{
			JOptionPane.showMessageDialog(rb2, "Thank You for visiting! ");
			Home2.this.dispose();
			new Login();
		}
		else
		{
			System.exit(0);
		}
		
	}
	private boolean isSufficient(double sweet, double reqMilk, double reqSugar, double reqKhoya, double ml, double sg,
			double kh) {
		// TODO Auto-generated method stub
		if(ml<reqMilk || sg<reqSugar || kh<reqKhoya )
		{
			if(ml<reqMilk)
			{
				JOptionPane.showMessageDialog(rb3, "Please add at least "+(reqMilk-ml)+" Ltr Milk", "Insufficient Material(s)", JOptionPane.ERROR_MESSAGE);
			}
			else if(sg<reqSugar)
			{
				JOptionPane.showMessageDialog(rb3, "Please add at least "+(reqSugar-sg)+" Kg Sugar", "Insufficient Material(s)", JOptionPane.ERROR_MESSAGE);
			}
			else if(kh<reqKhoya)
			{
				JOptionPane.showMessageDialog(rb3, "Please add at least "+(reqKhoya-kh)+" Kg Khoya", "Insufficient Material(s)", JOptionPane.ERROR_MESSAGE);
			}
			return false;
		}
		else
			return true;
	}
	
}
