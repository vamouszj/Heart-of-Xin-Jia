package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ArticleBeam;
import com.tita.Mod_Article;

/**
 * Servlet implementation class Del_Article_Servlet
 */
@WebServlet("/Del_Article_Servlet")
public class Del_Article_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Del_Article_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title_id=request.getParameter("title_id");
		Mod_Article MA=new Mod_Article();
		MA.Del_Article(Integer.parseInt(title_id));
		response.setCharacterEncoding("utf8");
		//request.getRequestDispatcher("Manage/Manange_index.jsp?page=1").forward(request, response);;
		response.sendRedirect("Manage/Manange_index.jsp?page=1");
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
