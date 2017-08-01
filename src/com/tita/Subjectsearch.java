package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.PowerBean;
import com.bean.SubjectBean;
import com.bean.TextBean;

public class Subjectsearch {
	private List<SubjectBean> subjectlist;
	private List<PowerBean> powerlist;
	public Subjectsearch(int TB){
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.Subject(TB);
		hbc.power(TB);
		subjectlist=hbc.getsubjectlist();
		powerlist=hbc.getPowerList();
		for(SubjectBean SB:subjectlist){
			int i=0;
			for(;i<powerlist.size();){
				if(SB.getSubject_id()==powerlist.get(i).getProblem_id()){
			
					break;
				}
				i++;
			}
			if(i>=powerlist.size()){
				powerlist.remove(i);
			}
		}
	}
	public List<PowerBean> getpowerList(){
		if(powerlist!=null){
			return powerlist;
		}else return null;
	}
	public List<SubjectBean> getList(){
		if(subjectlist!=null){
			return subjectlist;
		}else return null;
	}
}
