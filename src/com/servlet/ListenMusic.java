package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MusicInfo;
import com.google.gson.JsonObject;
import com.tita.Mod_Music;
import com.tita.VoiceServlet;

/**
 * Servlet implementation class ListenMusic
 */
@WebServlet("/ListenMusic")
public class ListenMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListenMusic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		int Music_id=Integer.parseInt(request.getParameter("music_id").toString());
		int jubge=0;
		String option=request.getParameter("option");
		if(option.equals("next")){
			jubge=1;
		}else{
			jubge=-1;
		}
		
		VoiceServlet VS=new VoiceServlet();
		List<MusicInfo> ML=VS.getList();
		int home_page=ML.get(0).getId();                 //第一首歌的ID
		int last_page=ML.get(ML.size()-1).getId();       //最后一首歌的ID
		
		Mod_Music MM=new Mod_Music();
		MusicInfo MI=null;
		while(MI==null&&Music_id-1>=home_page&&Music_id+1<=last_page){
			Music_id+=jubge;
			MM.Find_Condition_music(Music_id);
			MI=MM.getMI();
		}
		JsonObject jsobjcet = new JsonObject();
		if(MI!=null){
	        jsobjcet.addProperty("Music_name", MI.getMusic_name());
	        jsobjcet.addProperty("Music_song", MI.getMusic_song());
	        jsobjcet.addProperty("Music_type", MI.getMusic_type());
	        jsobjcet.addProperty("Music_id", MI.getId());
	        jsobjcet.addProperty("Music_route", MI.getMusic_route());
	        jsobjcet.addProperty("Music_judge", 1);
        }else{
        	jsobjcet.addProperty("Music_judge", 0);
        }
		 PrintWriter out = response.getWriter();
	        out.write(jsobjcet.toString());
	        out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
