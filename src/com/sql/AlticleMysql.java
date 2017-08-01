package com.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.ArticleBeam;
import com.bean.LangBean;

public class AlticleMysql {
	private String DRIVE="com.mysql.jdbc.Driver";
	private String ROUTE="jdbc:mysql://127.0.0.1:3306/hearthome";
	private String ACCOUNT="root";
	private String PASSWD="kairui00544ok";
	private Connection connection;
	private ArrayList list=new ArrayList();
	public AlticleMysql(){
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
				ResultSet resultSet=statemeng.executeQuery("select * from article");
				while(resultSet.next()){
					ArticleBeam articlebean=new ArticleBeam();
					articlebean.setArticle_tite(resultSet.getString(1));
					articlebean.setArticle_title(resultSet.getString(2));
					articlebean.setImage(resultSet.getString(5));
					list.add(articlebean);
				}
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		public ArrayList getat_list(){
			return list;
		}
}
