package com.tita;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.PourBean;

public class AjaxPourSearch {
	private List<PourBean> list;
	public void AjaxPourSearch(String datetime,String username){
	
		HibernectConnetc hbc=new HibernectConnetc();
//		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");//设置间转换器
//		String datetime=sf.format(time);
		
		System.out.println(username+"正在接受信息"+datetime);
		
		hbc.pour(datetime,username);
		list=hbc.getPouList();
		System.out.println(list.size());
	}
	public List<PourBean> getList(){
		if(list!=null){
				return list;
		}else return null;
	}
}
