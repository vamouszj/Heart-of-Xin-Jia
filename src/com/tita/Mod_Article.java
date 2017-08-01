package com.tita;

import com.Hibernate.HibernectConnetc;
import com.bean.ArticleBeam;

public class Mod_Article {

	public ArticleBeam Find_Article(int article_id){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Find_Condition_Article(article_id);
		ArticleBeam AB=hbc.getArticleList().get(0);
		return AB;
	}
	public void Mod_Article(ArticleBeam AB){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.ModArticle(AB);
	}
	public void Del_Article(int article_id){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Find_Condition_Article(article_id);
		ArticleBeam AB=hbc.getArticleList().get(0);
		hbc.DelActicle(AB);
	}
	
	public void Add_Article(ArticleBeam AB){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.AddArtcile(AB);
	}
}
