package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.LangBean;
import com.bean.RegisterBean;

public class Register_Mod {
	private int count;
	private List<RegisterBean> list;
	private HibernectConnetc hbc;
	public Register_Mod(){
		 hbc=new HibernectConnetc();
	}
	public void showResults(String user_name){
		hbc.Condition_REGISTER( user_name);
		list=hbc.getRegisterlist();
	}
	public Register_Mod(String User_id){
		HibernectConnetc Hibernate=new HibernectConnetc();
		Hibernate.Find_condition_Register(Integer.parseInt(User_id));
		Hibernate.Find_conditiono_Land(Integer.parseInt(User_id));
		LangBean LB=(LangBean)Hibernate.getList().get(0);
		RegisterBean RB=Hibernate.getRegisterlist().get(0);
		System.out.println(LB+"woshi "+RB);
		Hibernate.Del_Land(LB);
		Hibernate.Del_Register(RB);
	}
	public Register_Mod(int page){
		HibernectConnetc Hibernate=new HibernectConnetc();
		Hibernate.Register_all(page,10);
		Hibernate.Count_Register();
		list=Hibernate.getRegisterlist();
		count=Hibernate.getCount();
	}
	public List<RegisterBean> getList(){
		if(list!=null){
			return list;
		}else return null;
	}
	public int getCount(){
		if(count%10==0){
			return count/10;
		}else return count/10+1;
	}
}	
