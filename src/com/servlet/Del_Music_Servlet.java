package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MusicInfo;
import com.tita.Mod_Music;
import com.tita.VoiceServlet;

/**
 * Servlet implementation class Del_Music_Servlet
 */
@WebServlet("/Del_Music_Servlet")
public class Del_Music_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Del_Music_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String Music_id=request.getParameter("music_id");
		VoiceServlet VS=new VoiceServlet(Music_id);
		//request.getRequestDispatcher("Manage/musicList.jsp?page=1").forward(request, response);
		response.sendRedirect("Manage/musicList.jsp?page=1");
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
