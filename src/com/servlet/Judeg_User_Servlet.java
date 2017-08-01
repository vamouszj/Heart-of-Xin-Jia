package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.HibernectConnetc;
import com.bean.RegisterBean;



/**
 * Servlet implementation class Judeg_User_Servlet
 */
@WebServlet("/Judeg_User_Servlet")
public class Judeg_User_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Judeg_User_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String user_name=request.getParameter("userName");
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Condition_REGISTER(user_name);
		List<RegisterBean> RGL=hbc.getRegisterlist();
		
		String bool;
		if(RGL.size()==0){
			bool="false";
		}else bool="true";
		//System.out.println(RGL.size()+"  "+bool);
		PrintWriter out = response.getWriter();
		out.write(bool);
		out.close();
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
