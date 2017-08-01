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
 * Servlet implementation class editArticle_Servlet
 */
@WebServlet("/editArticle_Servlet")
public class editArticle_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public editArticle_Servlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		
//		String article_id=request.getSession().getAttribute("article_id").toString();
//		ArticleBeam AB=(ArticleBeam)request.getSession().getAttribute(article_id);
		String article_id=request.getParameter("title_id");
		String article_up_time=request.getParameter("title_up");
		String article_image=request.getParameter("title_img");
		ArticleBeam AB=new ArticleBeam();
		AB.setArticle_id(Integer.parseInt(article_id));
		AB.setArticle_tite(request.getParameter("title"));
		AB.setArticle_title(request.getParameter("content"));
		AB.setArticle_up_time(article_up_time);
		AB.setImage(article_image);
		Mod_Article MA=new Mod_Article();
		MA.Mod_Article(AB);
		
	//	request.getRequestDispatcher("Manage/Manange_index.jsp?page=1").forward(request, response);;
		response.sendRedirect("Manage/Manange_index.jsp?page=1");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
