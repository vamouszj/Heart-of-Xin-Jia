package com.tita;

import java.util.List;


import com.Hibernate.HibernectConnetc;
import com.bean.ArticleBeam;

public class SearchArticle {
	private List<ArticleBeam> list;
	private int Count;
	public SearchArticle(){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.ArticleFind();
		list=hbc.getArticleList();
	}
	public SearchArticle(int pages){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.FenArticle(pages, 6);
		
		hbc.Articleconut();
		Count=hbc.getCount();
		list=hbc.getArticleList();
	}
	public List<ArticleBeam> getList(){
		if(list!=null)
			return list;
		else return null;
	}
	public int getConut(){
		if(Count%6==0){
			return Count/6;
		}else {
			return Count/6+1;
		}
	}
	
}
