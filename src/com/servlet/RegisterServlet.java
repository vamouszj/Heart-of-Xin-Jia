package com.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.HibernectConnetc;
import com.bean.LangBean;
import com.bean.RegisterBean;
import com.sql.SQLStringNullException;
import com.xin.DButil;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		register(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 doGet(request, response);
	}
	
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	//	System.out.println("Ô]ƒÔé_Ê¼ÁË");
		RegisterBean register=new RegisterBean();
		LangBean LB=new LangBean();
		register.setUser_name(request.getParameter("user_name"));
		register.setUser_passwd(request.getParameter("user_passwd"));
		register.setRegister_phone_num(request.getParameter("register_phone_num"));
		register.setRegister_mailbox(request.getParameter("register_mailbox"));
		
		LB.setAccount(register.getUser_name());
		LB.setPasswd(register.getUser_passwd());
		
		HibernectConnetc hbc=new HibernectConnetc();
		String message = "";
		if(hbc.Registerservlet(register, LB)){
			message = "×¢²á³É¹¦,ÄúµÄÕËºÅÎª" + register.getUser_name();
		}else{
			message = "×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á";
		}
		
		request.setAttribute("message", message);
		request.getRequestDispatcher("index.jsp").forward(request, response);	
		
		
		
//		String sql = "select * from register";
//		int id = 0;
//		
//		try {
//			ResultSet rs = DButil.getInstance(sql).doQuery();
//			if(rs.last()){
//				id = rs.getRow();
//				rs.first();
//				System.out.println(id);
//				id += 1;
//			}
//		} catch (ClassNotFoundException | SQLStringNullException | SQLException e) {
//			e.printStackTrace();
//		}
//		
//		
//		
//		sql = "insert into register(register_id, user_name, user_passwd, register_phone_num, "
//				+ "register_mailbox) values('"+ id +"', '"+ user_name +"', '"+user_passwd +"', "
//						+ "'"+register_phone_num+"',  '"+ register_mailbox +"')";
//		String sql_land = "insert into land( user_name, user_passwd) values('"+ user_name +"', '"+user_passwd +"')";
//	//	System.out.println(sql_land);
//		int result = 0;
//		try {
//			result = DButil.getInstance(sql).doUpdate();
//			result = DButil.getInstance(sql_land).doUpdate();
//		} catch (ClassNotFoundException | SQLStringNullException | SQLException e) {
//			e.printStackTrace();
//		}
////		System.out.println("result:" +  result);
//		
//		String message = "";
//		if(result == 1){
//			message = "×¢²á³É¹¦,ÄúµÄÕËºÅÎª" + user_name;
//		}else{
//			message = "×¢²áÊ§°Ü£¬ÇëÖØÐÂ×¢²á";
//		}
//		
//		request.setAttribute("message", message);
//		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

}
