package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ArticleBeam;
import com.tita.Mod_Article;

/**
 * Servlet implementation class Add_Article_Servlet
 */
@WebServlet("/Add_Article_Servlet")
public class Add_Article_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_Article_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		String tite=request.getParameter("title");
		String tilte=request.getParameter("content");
		ArticleBeam AB=new ArticleBeam();
		AB.setArticle_tite(tite);
		AB.setArticle_title(tilte);
		Date date=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date_time=dateFormat.format(date);
		AB.setArticle_read_time(date);
		AB.setArticle_up_time(date_time);
		
		int number=new Random().nextInt(14)+1;
		String src="images/art_page/"+number+".jpg";
		AB.setImage(src);
		Mod_Article MA=new Mod_Article();
		MA.Add_Article(AB);
		response.sendRedirect("Manage/addArticle.jsp");
		
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
