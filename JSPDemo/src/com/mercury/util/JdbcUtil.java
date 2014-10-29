package com.mercury.util;
import java.sql.*;

public class JdbcUtil {
	private static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	private static final String URL="jdbc:oracle:thin:@jhfanPC:1521:XE";
	private static final String USERNAME="java";
	private static final String PASSWORD="12345";
	
	public static Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
}
