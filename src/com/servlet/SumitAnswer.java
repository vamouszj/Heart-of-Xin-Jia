package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Hibernate.HibernectConnetc;
import com.bean.PowerBean;
import com.bean.SubjectBean;
import com.bean.TextBean;
import com.bean.Text_answer_results;
import com.tita.Results;

/**
 * Servlet implementation class SumitAnswer
 */
@WebServlet("/SumitAnswer")
public class SumitAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SumitAnswer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		List<SubjectBean> SB=(List<SubjectBean>) request.getSession().getAttribute("subject");
		List<PowerBean> PB=(List<PowerBean>) request.getSession().getAttribute("power");
		//��ȡtest����
		TextBean textq=(TextBean)request.getSession().getAttribute(request.getSession().getAttribute("textstring").toString());
		
		String string;
		String answer;
		int sum=0;
		for(int i=0;i<SB.size();i++){
			string="question"+i;
			answer=request.getParameter(string);
			if(answer==null){
				sum+=0;
			}else if(answer.equals(PB.get(i).getSelect_A())){
					sum =sum+PB.get(i).getWeight_A();
			}else if(answer.equals(PB.get(i).getSelect_B())){
				sum+=PB.get(i).getWeight_B();
			}else if(answer.equals(PB.get(i).getSelect_C())){
				sum+=PB.get(i).getWeight_C();
			}else {
				sum+=PB.get(i).getWeight_D();	
			}
			
		}
	
			//����text�����в�������
		textq.setTest_pop_sum(textq.getTest_pop_sum()+1);
		HibernectConnetc hbc=new HibernectConnetc();
		hbc.UpdateText(textq);
		
		//��Ӳ��Խ��
		
		Results result=new Results();
		result.findresulte(textq.getTest_id(), sum);   //�鿴 Ȩֵ��Ӧ�Ĵ�
		Text_answer_results tar=null;
		tar=result.getText_answer_results();
		
		//System.out.println("��������ID:"+textq.getTest_id()+",���Խ��:"+tar.getTest_result()+",�����û�:"+request.getSession().getAttribute("name")+"Ȩֵ��"+sum);
		
		result.Results(textq.getTest_id(),tar.getTest_result(),request.getSession().getAttribute("name").toString(),sum);
		result.addResults();
		request.getSession().setAttribute("results", tar.getTest_result());
		request.getSession().setAttribute("sum", sum);
		request.getRequestDispatcher("test_detail/test_result.jsp").forward(request, response);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
