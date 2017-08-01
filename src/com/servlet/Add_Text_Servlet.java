package com.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.TextBean;
import com.tita.Mod_subject;
import com.tita.Mod_test;

/**
 * Servlet implementation class Add_Text_Servlet
 */
@WebServlet("/Add_Text_Servlet")
public class Add_Text_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Text_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String test_title=request.getParameter("title");
		String test_tite=request.getParameter("tite");
		System.out.println("测试题目是:"+test_title);
		List quest_anw_list=new ArrayList();
		for(int i=2;i<=20;i++){
			if(request.getParameter("question"+i)==null){
				break;
			}
			quest_anw_list.add(request.getParameter("question"+i));
			quest_anw_list.add(request.getParameter("question"+i+"1"));
			quest_anw_list.add(request.getParameter("question"+i+"2"));
			quest_anw_list.add(request.getParameter("question"+i+"3"));
		}	
		Mod_test MT=new Mod_test();
		//实例化test
		TextBean TB=new TextBean();
		TB.setTest_title(test_title);
		TB.setTest_abstract(test_tite);
		TB.setTest_pop_sum(0);
		
		MT.add_test(TB);
		TextBean add_succ_TB=MT.getTextBean();
		Mod_subject MS=new Mod_subject(add_succ_TB,quest_anw_list);
		MS.Coutule();
	
		   response.sendRedirect("Manage/addTest.jsp");
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
