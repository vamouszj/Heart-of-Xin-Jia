package com.bean;

import java.util.Date;

import javax.swing.JTextArea;

public class ArticleBeam {
	private int article_id;
	private String article_up_time;
	private Date article_read_time;
	private String article_tite;
	private String article_title;
	private String image;
	public int getArticle_id() {
		return article_id;
	}
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}
	public String getArticle_up_time() {
		return article_up_time;
	}
	public void setArticle_up_time(String article_up_time) {
		this.article_up_time = article_up_time;
	}
	public Date getArticle_read_time() {
		return article_read_time;
	}
	public void setArticle_read_time(Date article_read_time) {
		this.article_read_time = article_read_time;
	}
	public String getArticle_tite() {
		return article_tite;
	}
	public void setArticle_tite(String article_tite) {
		this.article_tite = article_tite;
	}
	public String getArticle_title() {
		return article_title;
	}
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}
	
	public void setImage(String image ){
		this.image=image;
	}
	public String getImage(){
		return image;
	}

	
}
