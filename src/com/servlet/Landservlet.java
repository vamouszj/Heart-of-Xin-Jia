package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.LangBean;
import com.bean.RegisterBean;
import com.sql.LandMysql;
import com.tita.Land;

/**
 * Servlet implementation class Landsevlet
 */
@WebServlet("/Landsevlet")
public class Landservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Landservlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account=request.getParameter("username");
		String passwd=request.getParameter("userPassword");
//		
//		LangBean landBean=new LangBean();
//		landBean.setAccount(account);
//		landBean.setPasswd(passwd);
//		
//		LandMysql landmysql=new LandMysql(landBean);
//		landmysql.LandMyqsl();
//		landmysql.lookup();
//		if(landmysql.getat_list()){
//			
//			request.setCharacterEncoding("utf-8");
//			request.getSession().setAttribute("name", landBean.getAccount());
//			request.setAttribute("username", landBean.getAccount());
//			request.getRequestDispatcher("index.jsp").forward(request, response);;
//	
//			
//		}else{
//			request.getRequestDispatcher("index.jsp").forward(request, response);;
//		}
//		
		Land land=new Land(account,passwd);

		if(land.judge()==true){
			
			request.setCharacterEncoding("utf-8");
			request.getSession().setAttribute("name", account);
			RegisterBean RB=land.getRegiste();
			request.getSession().setAttribute("Regist",RB);
			request.setAttribute("username", account);
			request.getRequestDispatcher("index.jsp").forward(request, response);;
		}else{
			request.getRequestDispatcher("index.jsp").forward(request, response);;
		}
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
