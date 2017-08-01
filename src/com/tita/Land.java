package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.LangBean;
import com.bean.RegisterBean;



public class Land {
	private List<LangBean> list;
	private String user;
	private String passwd;
	private RegisterBean registe;
	private List<RegisterBean> RLST;
	public Land(String user,String passwd){
		this.user=user;
		this.passwd=passwd;
		HibernectConnetc Hibernate=new HibernectConnetc();
		Hibernate.Land(user);
		list=Hibernate.getList();
	}
	public Boolean judge(){
		for(LangBean LB:list){
			if(passwd.equals(LB.getPasswd())){
				Register_Mod RM=new Register_Mod();
				RM.showResults( LB.getAccount());
				RLST=RM.getList();
				setRegiste(RLST.get(0));
				return true;
			}
		}
		return false;
	}
	public RegisterBean getRegiste() {
		return registe;
	}
	public void setRegiste(RegisterBean registe) {
		this.registe = registe;
	}
	
}
