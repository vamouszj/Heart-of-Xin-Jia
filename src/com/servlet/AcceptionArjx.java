package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.PourBean;
import com.google.gson.JsonObject;
import com.tita.AjaxPourSearch;

/**
 * Servlet implementation class AcceptionArjx
 */
@WebServlet("/AcceptionArjx")
public class AcceptionArjx extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Date time;  
    public AcceptionArjx() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
	    response.setContentType("text/xml;charset=UTF-8");
	
	    String string = null;
	    String username=request.getSession().getAttribute("name").toString();
	    String string_time=request.getParameter("date_time");
	    System.out.println(string_time);
	    if(string_time.length()>"2016-12-06 15-35-40".length()){
	    	String time=string_time.substring(0, 8);
	    	String date=string_time.substring(string_time.length()-10,string_time.length());
	    	date=date.replace("-", "/");
	    	string_time=date+" "+time;
	    }

	    System.out.println("初始化时间为"+string_time);
	    Map date_time=new HashMap();
	    if(date_time.isEmpty() || !date_time.containsKey(username)){
	    	date_time.put(username,string_time); 
	    	string_time= date_time.get(username).toString();
	    }
	   

		AjaxPourSearch APS=new AjaxPourSearch();
		APS.AjaxPourSearch(string_time,username);
		List<PourBean> list=APS.getList();
		if(list.size()>0){
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			 string_time=list.get(list.size()-1).getPour_out_time();
		
			 string_time=string_time.substring(0, string_time.length()-2);
			System.out.println("接受到消息的时间"+string_time);
			date_time.put(username, string_time);
		}
		//System.out.println(request.getSession().getAttribute("name")+"在"+date_time.get(username)+"收到消息");
		PrintWriter out = response.getWriter();
		StringBuffer sb = new StringBuffer("");
		for(PourBean pb:list){
			sb.append("<li><img src="+"./images/user.jpg"+"><span>" 
					+ pb.getPour_out_title() + "</span></li>");
		}
		
		JsonObject jsobjcet = new JsonObject();
		 jsobjcet.addProperty("date_time", string_time);
		 jsobjcet.addProperty("message", sb.toString());
      //  out.write(sb.toString());
        out.write(jsobjcet.toString());
        out.close();
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
