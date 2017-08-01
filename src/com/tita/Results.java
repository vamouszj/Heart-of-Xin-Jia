package com.tita;

import java.util.List;

import com.Hibernate.HibernectConnetc;
import com.bean.ResultsBean;
import com.bean.Text_answer_results;

public class Results {
	private ResultsBean RB=new ResultsBean();
	private HibernectConnetc hbc;
	private List<Text_answer_results> test_results_List;
	public Results(){
		 hbc=new HibernectConnetc();
	}
	
	public void Results(int test_id,String result,String user_name,int sum){
		
		RB.setTest_id(test_id);
		RB.setResult(result);
		RB.setUser_name(user_name);
		RB.setTest_sum_Weight(sum);
		
	}
	public void addResults(){
		//HibernectConnetc hbc=new HibernectConnetc();
		hbc.resluts(RB);
	}
	public void findresulte(int test_id,int sum){
		sum=sum/10;
		sum=sum*10+5;
		hbc.Text_results(test_id,sum);
		test_results_List=hbc.getTest_results_List();
	}
	public Text_answer_results getText_answer_results(){
		if(test_results_List.size()!=0){
			return test_results_List.get(0);
		}else return null;
	}
}
