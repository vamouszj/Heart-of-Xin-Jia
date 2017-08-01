package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.HibernectConnetc;
import com.bean.PourBean;

/**
 * Servlet implementation class Pouer
 */
@WebServlet("/Pouer")
public class Pouer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Pouer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/xml;charset=UTF-8");
		String messing=request.getParameter("mess");
		System.out.println("runing"+messing);
		Date time=new Date();
	
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置间转换器
		String datetime=sf.format(time);
		String user_name=request.getSession().getAttribute("name").toString();
		
		System.out.println(user_name+"在"+datetime+"发送消息");
		
		PourBean PB=new PourBean();
		PB.setUser_name(user_name);
		PB.setPour_out_title(messing);
		PB.setPour_out_time(datetime);
		
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Addpour(PB);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
