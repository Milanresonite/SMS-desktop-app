package com.milan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
    public static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded");
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "12345");
			System.out.println("connection established");
			return con;
		}
		catch(ClassNotFoundException e1)
		{System.out.println("Driver not loaded");
		System.out.println(e1);
		return con;
	    }
	catch(SQLException e2)
	{
		System.out.println("Connection not established");
		e2.printStackTrace();
		return con;
	}
	}
}
