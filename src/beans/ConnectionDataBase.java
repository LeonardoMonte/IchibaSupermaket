package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.DatabaseMetaData;

import negocios.Fachada;

public class ConnectionDataBase {

	
	public static Connection getConnection2() throws Exception
	{
		
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/IchibaSuperMarket?autoReconnect=true&useSSL=false";
			String username = "brmonte";
			String password = "dofus33777731";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			
			
			return conn;
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		
		
		
		return null;
		
	}
	
	
	public static Connection getConnection(String username, String password) throws Exception
	{
		
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/IchibaSuperMarket?autoReconnect=true&useSSL=false";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url, username, password);
			
			
			
			return conn;
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		
		
		
		return null;
		
	}
	
	
	
}
