package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.DatabaseMetaData;

import negocios.Fachada;

public class ConnectionDataBase {

	
	public static void main(String args[]) throws Exception
	{
			
			String rua = "123";
			String bairro = "123";
			String cep = "123";
			String estado = "123";
			String codigo = "123";
			boolean status2 = true;
			System.out.println("update fornecedor set rua = '"+ rua+"' , bairro = '"+bairro+"' , CEP = '"+ cep+"', estado = '"+ estado+"' , ativo = "+ status2	+ " where cod = '"+ codigo +"' ;" );
			
		
		
	}
	
	public static Connection getConnection() throws Exception
	{
		
		try
		{
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/IchibaSuperMarket?autoReconnect=true&useSSL=false";
			String username = "brmonte";
			String password =  "dofus33777731";
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
