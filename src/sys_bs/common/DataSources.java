package sys_bs.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataSources {
	private static Connection conn=null;
	private static Statement st=null;
	
	/**
	 * 获取Statement对象
	 * @return
	 * @throws SQLException 
	 */
	public static Statement getst(){
		Properties properties=new Properties();
		String jdbc="jdbc.properties";
		InputStream is = DataSources.class.getClassLoader().getResourceAsStream(jdbc);
		try{
			properties.load(is);
		}catch(IOException e1){
			e1.printStackTrace();
		}
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String usename = properties.getProperty("username");
		String password = properties.getProperty("password");
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,usename,password);
			st = conn.createStatement();
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return st;
	}
	
	
/**
 * 	获取connection对象
 * @return
 */
public static Connection getconn(){
		Properties properties = new Properties();
		String jdbc = "jdbc.properties";
		InputStream is = DataSources.class.getClassLoader().getResourceAsStream(jdbc);
		try{
			properties.load(is);
		}catch (IOException e1){
			e1.printStackTrace();
		}
		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");
		try{
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Statement对象关闭    
	 * @param rs
	 * @param pst
	 * @param conn
	 */
	public static void close(ResultSet rs,PreparedStatement pst,Connection conn){
		if(null != rs){
			try{
				rs.close();
			}catch (SQLException e){
			e.printStackTrace();
			}
		}
		if(null != pst){
			try{
				pst.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(null != conn){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * connection对象关闭
	 * @param rs
	 * @param st
	 * @param conn
	 */
	public static void closeall(ResultSet rs,Statement st,Connection conn){
		if(null != rs){
			try{
				rs.close();
			}catch (SQLException e){
			e.printStackTrace();
			}
		}
		if(null != st){
			try{
				st.close();
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		if(null != conn){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	
	
}
