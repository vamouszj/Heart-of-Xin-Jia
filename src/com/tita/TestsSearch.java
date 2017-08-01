package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.TextBean;

public class TestsSearch {
	private List<TextBean> list;
	private int Count;
	public TestsSearch(){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Test();
		list=hbc.getTestList();
	}
	public TestsSearch(int pages){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Testconut();
		setCount(hbc.getCount());
		hbc.FenText(pages, 5);
		list=hbc.getTestList();
	}
	public List<TextBean> getlist(){
		if(list!=null){
			return list;
		}
		return null;
	}
	public int getCount() {
		
		if(Count%5==0){
		
			return Count/5;
		}
		return Count/5+1;
	}
	public void setCount(int count) {
		Count = count;
	}
}
