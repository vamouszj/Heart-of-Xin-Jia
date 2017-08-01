package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.PowerBean;
import com.bean.SubjectBean;
import com.bean.TextBean;

public class Mod_test {
	private HibernectConnetc hbc;
	private TextBean TBean;
	private SubjectBean SB;
	private PowerBean PB;
	private List<TextBean> TL;
	private List<SubjectBean> SBL;
	private List<PowerBean> PBL;
	private int Test_id;
	public Mod_test(){
		hbc=new HibernectConnetc();
	}
	public void add_test(TextBean TB){
		hbc.Add_Text(TB);
		hbc.Test();
		TL=hbc.getTestList();
		TBean=TL.get(TL.size()-1);
	}
	public TextBean getTextBean(){
		return TBean;
	}
	
	public void Del_test(int Test_id){
		hbc.Find_Condition_Text(Test_id);
		TBean=hbc.getTestList().get(0);
		//寻找题目对象
		hbc.Subject(TBean.getTest_id());
		SBL=hbc.getsubjectlist();
		
		//寻找答案对象
		
		hbc.power(TBean.getTest_id());
		PBL=hbc.getPowerList();
		//删除每个对象
		for(int i=0;i<SBL.size();i++){
			hbc.Del_Power(PBL.get(i));
			hbc.Del_Subject(SBL.get(i));
		}
		hbc.Del_Text(TBean);
	}
}
