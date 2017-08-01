package com.sql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.LangBean;

public class LandMysql {
	private String DRIVE="com.mysql.jdbc.Driver";
	private String ROUTE="jdbc:mysql://127.0.0.1:3306/hearthome";
	private String ACCOUNT="root";
	private String PASSWD="kairui00544ok";
	private LangBean langBean;
	private Connection connection;
	private boolean at_list=false;
	public LandMysql(LangBean langBean){
			this.langBean=langBean;
	}
	public void LandMyqsl(){
	try {
		Class.forName(DRIVE);
		connection=DriverManager.getConnection(ROUTE,ACCOUNT,PASSWD);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
			
		
	}
	public void lookup(){
		try {
			Statement	statemeng = connection.createStatement();
			ResultSet resultSet=statemeng.executeQuery("select * from land");
			while(resultSet.next()){
				if(langBean.getAccount().equals(resultSet.getString(1))){
					if(langBean.getPasswd().equals(resultSet.getString(2))){
						at_list=true;
					}
				}
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	public boolean getat_list(){
		return at_list;
	}
	
	
}
