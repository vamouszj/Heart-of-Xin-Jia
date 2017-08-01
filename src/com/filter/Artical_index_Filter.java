package com.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bean.ArticleBeam;
import com.sql.AlticleMysql;


@WebFilter("/Artical_index_Filter")
public class Artical_index_Filter implements Filter {
	private ArrayList list;
   private AlticleMysql asql;
 
    public Artical_index_Filter() {
        // TODO Auto-generated constructor stub
    }


	public void init(FilterConfig fConfig) throws ServletException {
		list=new ArrayList();
		 asql=new AlticleMysql();
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
	    asql.lookup();
	    list=asql.getat_list();
	    request.setCharacterEncoding("utf-8");
	    for(int i=0;i<3;i++){
	    	int number=new Random().nextInt(list.size())+1;
	    	String str=Integer.toString(i);
	    	ArticleBeam bean=(ArticleBeam)list.get(number-1);
	    	request.setAttribute(str, bean);
	    }
		chain.doFilter(request, response);
	}
	public void destroy() {
	
	}
}
