package com.xin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sql.SQLStringNullException;

public class DButil {
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String dbURL = "jdbc:mysql://localhost:3306/hearthome";
	public static String userName = "root";
	public static String userPass = "kairui00544ok";
	public static String dbName = "hearthome";
	public static String URL = "jdbc:mysql://localhost/" + dbName + "?user="
			 + userName + "&password=" + userPass + 
			 "&useUnicode=true&characterEncoding=utf8";
	
	
	public static Connection conn = null;
	
	private String SQLString;
	
	public DButil(String SQLString) {
		this.SQLString = SQLString;
	}
	
	public DButil() {
		this(null);
	}
	
	public static void init() throws SQLException, ClassNotFoundException{
		if(conn == null){
			Class.forName(driverName);
			conn = (Connection) DriverManager.getConnection(URL);
		}
	}
	
	public ResultSet doQuery(String SQLString) throws SQLStringNullException, SQLException{		
		if(SQLString == null){
			throw new SQLStringNullException();
		}
		
		PreparedStatement state = (PreparedStatement)conn.prepareStatement(SQLString);
		ResultSet rs = state.executeQuery();
		return rs;
	}
	
	public ResultSet doQuery() throws SQLStringNullException, SQLException{
		return doQuery(this.SQLString);
	}
	
	public int doUpdate(String SQLString) throws SQLStringNullException, SQLException{
		if(SQLString == null){
			throw new SQLStringNullException();
		}
		PreparedStatement state = (PreparedStatement) conn.prepareStatement(SQLString);
		return state.executeUpdate();
	}
	
	public int doUpdate() throws SQLStringNullException, SQLException{
		return doUpdate(this.SQLString);
	}
	
	public static DButil getInstance(String SQLString) throws ClassNotFoundException, SQLException{
		init();

		DButil dbUl = new DButil(SQLString);
		return dbUl;
	}
	
	public static void disConnection() throws SQLException{
		if(conn != null){
			conn.close();
			conn = null;
		}
	}
	

	public String getSQLString() {
		return SQLString;
	}

	public void setSQLString(String sQLString) {
		SQLString = sQLString;
	}
	
	
	
	
}
