package com.milan;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;

import javax.swing.*;

public class AddMaterial extends JFrame implements ActionListener, ItemListener{

	
	JButton b1,b2,b3,b4;
	JTextField tf;
	JLabel l1,l2,l3;
	JRadioButton rb1,rb2,rb3;
	Container c;
	
	public AddMaterial() {
	
		c = getContentPane();
		c.setBackground(Color.pink);
		l1 = new JLabel("Sweet shop");
		l2 = new JLabel("Choose one to Add");
		l3 = new JLabel();
		rb1 = new JRadioButton("  Add Milk");
		rb2 = new JRadioButton("  Add Sugar");
		rb3 = new JRadioButton("  Add Khoya");
		b1 = new JButton("Log Out");
		b2 = new JButton("Click to procced");
		b3 = new JButton("Quit");
		b4 = new JButton("Back");
		
		tf = new JTextField();
		tf.setEditable(false);
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
		add(l3);
		add(b3);
		add(b4);
		add(l2);
		add(rb1);
		add(rb2);
		add(rb3);
		add(tf);
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		b4.setBounds(30,30,80,30);
		b1.setBounds(550,30,80,30);
		l1.setBounds(250,60,400,40);
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
		
		l3.setBounds(100,340,160,30);
		l3.setForeground(Color.RED);
		tf.setBounds(270,340,50,20);
		b2.setBounds(80, 420, 200, 30);
		b3.setBounds(380, 420, 100, 30);
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		rb1.addItemListener(this);
		rb2.addItemListener(this);
		rb3.addItemListener(this);
		
		
		
		
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(rb1.isSelected())
		{
			l3.setText("Enter amount of Milk (Ltr):");
			tf.setEditable(true);
		}
		else if(rb2.isSelected())
		{
			l3.setText("Enter amount of Sugar (Kg):");
			tf.setEditable(true);
		}
		else if(rb3.isSelected())
		{
			l3.setText("Enter amount of Khoya (Kg):");
			tf.setEditable(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			try {
			Connection cn = ConnectionProvider.getConnection();
			Statement st = cn.createStatement();
			/*st.executeUpdate("create table rawmaterial(MILK DOUBLE PRECISION, SUGAR DOUBLE PRECISION, KHOYA DOUBLE PRECISION)");
			st.executeUpdate("insert into rawmaterial values (2.2, 0, 3.6)");*/
			//PreparedStatement ps = cn.prepareStatement("update rawmaterial set MILK=?, SUGAR=?, KHOYA=? ");
			
			System.out.println("Hello");
			ResultSet rs = st.executeQuery("select * from rawmaterial");
			System.out.println(rs.next());
			System.out.println(1);
			double ml = rs.getDouble(1);
			double sg = rs.getDouble(2);
			double kh = rs.getDouble(3);
			
			//PreparedStatement ps1 = cn.prepareStatement("update rawmaterial set ?=? where ?=?");
			System.out.println(2);
		    String val = tf.getText();
		   
			
			if(rb1.isSelected())
			{     double d = Double.parseDouble(val);
				PreparedStatement ps = cn.prepareStatement("update rawmaterial set MILK="+(ml+d)+" ");
				System.out.println(3);
				/*ps.setString(1, "MILK");
				ps.setDouble(2, (ml+d));
				ps.setString(3, "MILK");
				ps.setDouble(4, (ml));
				System.out.println(ml);*/
				ps.executeUpdate();
				JOptionPane.showMessageDialog(rb1, "Successfully Added");
			}
			else if(rb2.isSelected())
			{     double d = Double.parseDouble(val);
				PreparedStatement ps = cn.prepareStatement("update rawmaterial set SUGAR="+(sg+d)+" ");
				ps.executeUpdate();
				JOptionPane.showMessageDialog(rb1, "Successfully Added");
			}
			else if(rb3.isSelected())
			{     double d = Double.parseDouble(val);
				PreparedStatement ps = cn.prepareStatement("update rawmaterial set KHOYA="+(kh+d)+" ");
				ps.executeUpdate();
				JOptionPane.showMessageDialog(rb1, "Successfully Added");
				ps.close();
			}
			else if(!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected())
			{
				JOptionPane.showMessageDialog(null,"Please select an option");	
			}
			st.close();
			cn.close();
			rs.close();
			}
			catch(Exception e3)
			{System.out.println(e3);}
		}
		else if(e.getSource()==b4)
		{
			AddMaterial.this.dispose();
			new Home2();
		}
		else if(e.getSource()==b1)
		{
			AddMaterial.this.dispose();
			new HomePage();
		}
		else
		{
			JOptionPane.showMessageDialog(rb2, "Thank you");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		new AddMaterial();
	}
}
