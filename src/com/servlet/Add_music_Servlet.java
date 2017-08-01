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
		
        // PageContext��jsp�����ö�����servlet����ֱ��ʹ�ã���Ҫ��һЩ����
        JspFactory _jspxFactory = JspFactory.getDefaultFactory();
        PageContext pageContext = _jspxFactory.getPageContext(this, request, response, "", true, 8192, true);
        // ��ʼ��
        mySmartUpload.initialize(pageContext);
        // �������ص����ֵ,ע��:����������ù�����������!
       // mySmartUpload.setMaxFileSize(10 * 1024 * 1024);
        // �����ļ�
        try
        {
            mySmartUpload.upload("utf-8");
            // mySmartUpload.save("d:\\jsp\\"); // TODO:ֻ��ԭ�����棬���ܸ���
        }
        catch (SmartUploadException e)
        {
            e.printStackTrace();
        }

        // ȡ�����ص��ļ�
        com.jspsmart.upload.File myFile = mySmartUpload.getFiles().getFile(0);
        if (!myFile.isMissing())
        {
            // ȡ�ñ�Ĳ���
        	
            String Music_name = (String) mySmartUpload.getRequest().getParameter("Music_name");
            String Music_song = (String) mySmartUpload.getRequest().getParameter("Music_song");
            String Music_type = (String) mySmartUpload.getRequest().getParameter("Music_type");
            // ȡ�����ص��ļ����ļ���
            String myFileName = myFile.getFileName();
            // ȡ�ò�����׺���ļ���
          //  String suffix = myFileName.substring(0, myFileName.lastIndexOf('.'));
            // ȡ�ú�׺��
       //     String ext = myFile.getFileExt();
        
            String aa=new String("F:/��������/workpace/textܰ/WebContent/music/");
            File aadir = new File(aa);
            if (!aadir.exists())
                aadir.mkdirs();
	            String trace = aa + myFileName;
	            System.out.println(trace +"  "+Music_name);
	            // ���ļ������ڷ�������(ʹ��ȫ·��)
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
