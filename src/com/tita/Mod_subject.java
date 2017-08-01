package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.PowerBean;
import com.bean.SubjectBean;
import com.bean.TextBean;

public class Mod_subject {
	private TextBean TB;
	private List TL;
	private HibernectConnetc hbc;
	private PowerBean PB;          //´ð°¸
	private SubjectBean SB;         //ÌâÄ¿ 
	private List<SubjectBean> sb_list;
	public Mod_subject(TextBean TB,List TL){
		this.TB=TB;
		this.TL=TL;
	 hbc=new HibernectConnetc();
	}
	public void Coutule(){
		int count=0;
		while(count!=TL.size()){
			SB=new SubjectBean();
			SB.setProblem(TL.get(count).toString());
			SB.setTest_id(TB.getTest_id());
			hbc.Add_subject(SB);
			hbc.Find_subject();
			SB=hbc.getsubjectlist().get(hbc.getsubjectlist().size()-1);
			count++;
			PB=new PowerBean();
			PB.setSelect_A(TL.get(count++).toString());
			PB.setSelect_B(TL.get(count++).toString());
			PB.setSelect_C(TL.get(count++).toString());
			PB.setWeight_A(5);
			PB.setWeight_B(3);
			PB.setWeight_C(2);
			PB.setProblem_id(SB.getSubject_id());;
			PB.setTest_id(TB.getTest_id());
			hbc.Add_power(PB);
		}
		
	}
	public void Add_subject(){
		
	}
}
