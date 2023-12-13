//package ors;
//connection.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
public class Connection1
{
		public Connection con;
		public Connection1()
		{
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver loaded...");
				
				con =DriverManager.getConnection("jdbc:mysql:///ors?useSSL=false","root","root");
				System.out.println("Connected....");
			}
			catch(Exception e1)
			{
				System.out.println(e1);
			}
		}
		public Statement createStatement1() {
			// TODO Auto-generated method stub
			return null;
		}
		public PreparedStatement prepareStatement(String string) {
			// TODO Auto-generated method stub
			return null;
		}
		public Statement createStatement(int typeScrollInsensitive, int concurReadOnly) {
			// TODO Auto-generated method stub
			return null;
		}
		public Statement createStatement11() {
			// TODO Auto-generated method stub
			return null;
		}
} 