package com.servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.bean.MusicInfo;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.tita.Mod_Music;
/**
 * Servlet implementation class Add_music_Servlet
 */
@WebServlet("/Add_music_Servlet")
public class Add_music_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add_music_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SmartUpload mySmartUpload = new SmartUpload();
		
        // PageContext是jsp的内置对象，在servlet不能直接使用，需要做一些处理
        JspFactory _jspxFactory = JspFactory.getDefaultFactory();
        PageContext pageContext = _jspxFactory.getPageContext(this, request, response, "", true, 8192, true);
        // 初始化
        mySmartUpload.initialize(pageContext);
        // 设置上载的最大值,注意:如果这里设置过大会出现问题!
       // mySmartUpload.setMaxFileSize(10 * 1024 * 1024);
        // 上载文件
        try
        {
            mySmartUpload.upload("utf-8");
            // mySmartUpload.save("d:\\jsp\\"); // TODO:只能原名保存，不能改名
        }
        catch (SmartUploadException e)
        {
            e.printStackTrace();
        }

        // 取得上载的文件
        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0);
        if (!myFile.isMissing())
        {
            // 取得别的参数
        	
            String Music_name = (String) mySmartUpload.getRequest().getParameter("Music_name");
            String Music_song = (String) mySmartUpload.getRequest().getParameter("Music_song");
            String Music_type = (String) mySmartUpload.getRequest().getParameter("Music_type");
            // 取得上载的文件的文件名
            String myFileName = myFile.getFileName();
            // 取得不带后缀的文件名
          //  String suffix = myFileName.substring(0, myFileName.lastIndexOf('.'));
            // 取得后缀名
       //     String ext = myFile.getFileExt();
        
            String aa=new String("F:/程序数据/workpace/text馨/WebContent/music/");
            File aadir = new File(aa);
            if (!aadir.exists())
                aadir.mkdirs();
	            String trace = aa + myFileName;
	            System.out.println(trace +"  "+Music_name);
	            // 将文件保存在服务器端(使用全路径)
	            try
	            {
	                myFile.saveAs(trace, mySmartUpload.SAVE_PHYSICAL);
	            }
	            catch (SmartUploadException e)
	            {
	                e.printStackTrace();
	            }
	            MusicInfo MI=new MusicInfo();
	            MI.setMusic_name(Music_name);
	            MI.setMusic_song(Music_song);
	            MI.setMusic_type(Music_type);
	            MI.setMusic_route("music/"+myFileName);
	            Mod_Music MM=new Mod_Music();
	            MM.Add_Music(MI);
	            response.sendRedirect("Manage/addMusic.jsp");
	         //   request.getRequestDispatcher("Manage/addMusic.jsp").forward(request, response);

        }
    
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
