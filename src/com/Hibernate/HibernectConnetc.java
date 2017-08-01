package com.Hibernate;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.bean.ArticleBeam;
import com.bean.LangBean;
import com.bean.MusicInfo;
import com.bean.PourBean;
import com.bean.PowerBean;
import com.bean.RegisterBean;
import com.bean.ResultsBean;
import com.bean.SubjectBean;
import com.bean.TextBean;
import com.bean.Text_answer_results;


public class HibernectConnetc {
	private List<LangBean> langlist;
	private List<RegisterBean> registerlist;
	private List<ArticleBeam> articleList;
	private List<MusicInfo> MusicList;
	private List listCount;
	private List<TextBean> TextList;
	private List<SubjectBean> subjectList;
	private List<PowerBean> powerList;
	private List<PourBean> pourList;
	private List<Text_answer_results> test_results_List;
	/*
	 * ��½��ѯ
	 */
	public void Land(String string){
	    Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			/*
			 * ��ѯ����ʵ�����
			 * ���� from��ߵĲ��Ǳ����Ƕ�������
			 */
			Query query=session.createQuery("from LangBean LB where LB.account=?");           //��ѯ��ʵ�����ȫ������
			query.setString(0, string);
			langlist=(List<LangBean>)query.list();
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Find_conditiono_Land(int user_id){
	    Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			/*
			 * ��ѯ����ʵ�����
			 * ���� from��ߵĲ��Ǳ����Ƕ�������
			 */
			Query query=session.createQuery("from LangBean LB where LB.id=?");           //��ѯ��ʵ�����ȫ������
			query.setInteger(0, user_id);
			langlist=(List<LangBean>)query.list();
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Del_Land(LangBean LB){
		   Transaction tx=null;
			 Session session=null;
			 HibernateUtil hibernate =new HibernateUtil();
			try{
				session=(Session) hibernate.getSession();
				tx=session.beginTransaction();
				
				session.delete(LB);
				
				
				tx.commit();
			}catch(Exception e){
				tx.rollback();
			}finally{
				session.close();
			}
	}
	
	public List getList(){
		if(langlist!=null)
			return langlist;
		else return null;
	}
	/*
	 * ע��
	 */
	public boolean Registerservlet(Object obj1,Object obj2){
		Transaction tx=null;
		 Session session=null;
		 	HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			session.save(obj1);
			session.save(obj2);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
			System.out.println("����û���ύ�ɹ�");
			return false;
		}finally{
			session.close();
		}
		return true;
	}
	
	public void Count_Register(){           //ͳ��
		 Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(RB.R_id) from RegisterBean RB");           //��ѯ��ʵ�����ȫ������
			listCount=query.list();
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void Register_all(int pagenum,int pagesize){             //��ҳ��ѯ
	    Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			/*
			 * ��ѯ����ʵ�����
			 * ���� from��ߵĲ��Ǳ����Ƕ�������
			 */
			String hql="from RegisterBean";
			Query query=session.createQuery(hql).setFirstResult((pagenum-1)*pagesize).setMaxResults(pagesize);
			registerlist=(List<RegisterBean>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Condition_REGISTER(String User_name){          //�û�������Ϣ��ʾ
		 Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			String hql="from RegisterBean RB where RB.user_name=?";
			Query query=session.createQuery(hql);
			
			query.setString(0, User_name);
			registerlist=(List<RegisterBean>)query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Find_condition_Register(int re_id){                  //��ѯ����
		   Transaction tx=null;
			 Session session=null;
			 HibernateUtil hibernate =new HibernateUtil();
			try{
				session=(Session) hibernate.getSession();
				tx=session.beginTransaction();
				String hql="from RegisterBean RB where RB.R_id=?";
				Query query=session.createQuery(hql);
				query.setInteger(0,re_id);
				registerlist=(List<RegisterBean>)query.list();
				tx.commit();
			}catch(Exception e){
				tx.rollback();
			}finally{
				session.close();
			}
	}
	public void Del_Register(RegisterBean RB){             //ɾ��
		Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			session.delete(RB);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public List<RegisterBean> getRegisterlist(){
		return registerlist;
	}
	
	/*
	 * ����
	 */
	public void ArticleFind(){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from ArticleBeam");
			setArticleList((List<ArticleBeam>)query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		
	}
	public void Find_Condition_Article(int Aticle_id){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from ArticleBeam AB where AB.article_id=?");
			query.setInteger(0,Aticle_id );
			setArticleList((List<ArticleBeam>)query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void setArticleList(List<ArticleBeam> articleList){
		this.articleList=articleList;
	}
	public List<ArticleBeam> getArticleList(){
		return articleList;
	}
	public void Articleconut(){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(ab.article_id) from ArticleBeam ab");
			listCount=query.list();
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void ModArticle(ArticleBeam AB){                          //�޸�
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.update(AB);
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void DelActicle(ArticleBeam AB){                             //ɾ��
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.delete(AB);
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		//	System.out.println("ɾ���ɹ�");
		}
	}
	public void AddArtcile(ArticleBeam AB){                                   //���
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.save(AB);
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void FenArticle(int pageno,int pagesize){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			String hql="from ArticleBeam";
			Query query=session.createQuery(hql).setFirstResult((pageno-1)*pagesize).setMaxResults(pagesize);
			setArticleList((List<ArticleBeam>)query.list());
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	
	
	public int getCount(){
		int count=Integer.parseInt(listCount.get(0).toString());
		if(count==0){
			return 0;
		}
		return count;
	}
	/*
	 * ����
	 */
	
	public void Music(){              //����
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from MusicInfo");
			setMusicList((List<MusicInfo>)query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		
	}
	public void Find_condition_Music(int music_id){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from MusicInfo MI where MI.id=?");
			query.setInteger(0, music_id);
			setMusicList((List<MusicInfo>)query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
		
	}
	public void setMusicList(List<MusicInfo> MusicList) {
		// TODO Auto-generated method stub
		this.MusicList=MusicList;
	}
	public List<MusicInfo> getMusicList(){
		
		return MusicList;
	}
	public void fenMusix(int pageno,int pagesize){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			String hql="from MusicInfo";
			Query query=session.createQuery(hql).setFirstResult((pageno-1)*pagesize).setMaxResults(pagesize);
			setMusicList((List<MusicInfo>)query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void Musicconut(){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(MI.id) from MusicInfo MI");
			listCount=query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void DelMusic(MusicInfo MI){                 //ɾ������
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.delete(MI);
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void AddMusic(MusicInfo MI){                         //�������
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.save(MI);
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	//����
	public void Test(){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from TextBean TB");
			setTestList(query.list());
		
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void setTestList(List TextList){
		this.TextList=(List<TextBean>)TextList;
	}
	public List<TextBean> getTestList(){
		if(TextList!=null)
			return TextList;
		return null;
	}
	//ͳ�Ʋ�������Ŀ
	public void Testconut(){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(TB.test_id) from TextBean TB");
			listCount=query.list();
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	//��ҳ
	public void FenText(int pageno,int pagesize){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			String hql="from TextBean";
			Query query=session.createQuery(hql).setFirstResult((pageno-1)*pagesize).setMaxResults(pagesize);
			setTestList((List<TextBean>)query.list());
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void Add_Text(TextBean test){                  //��Ӳ�����
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
		//	String hql="update TextBean";
			session.save(test);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void Find_Condition_Text(int text_id){                //������ѯ
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from TextBean TB where TB.test_id=?");
			query.setInteger(0, text_id);
			setTestList(query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void UpdateText(TextBean test){      //���²������� 
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
		//	String hql="update TextBean";
			session.update(test);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	//ɾ��������
	public void Del_Text(TextBean test){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
		//	String hql="update TextBean";
			session.delete(test);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	
	
	//������Ŀ
	public void Subject(int test){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from SubjectBean SB where SB.test_id=?");
			query.setInteger(0, test);
			setSubjectList(query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Find_subject(){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from SubjectBean");
			setSubjectList(query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Add_subject(SubjectBean SB){               //��ӡ�
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.save(SB);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void setSubjectList(List<SubjectBean> subjectList){
		this.subjectList=subjectList;
	}
	public List<SubjectBean> getsubjectlist(){
		if(subjectList!=null){
			return subjectList;
		}else return null;
	}
	public void Del_Subject(SubjectBean SB){               //ɾ��
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.delete(SB);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	//������ѡ��
	public void power(int testid){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from PowerBean PB where  PB.test_id=?");
			query.setInteger(0, testid);
			setPowerList(query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Add_power(PowerBean PB){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.save(PB);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void Del_Power(PowerBean PB){                 //ɾ��ѡ��
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.delete(PB);
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public void setPowerList(List<PowerBean> powerList){
		this.powerList=powerList;
	}
	public List<PowerBean> getPowerList(){
		return powerList;
	}
	/*
	 * ����
	 * 
	 */
	public void pour(String time,String username){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from PourBean PB where  PB.pour_out_time > ? and PB.user_name!=? ");
			query.setString(0, time);
			query.setString(1, username);
		//	Query query=session.createQuery("from PourBean ");
			setPourList(query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}

	public void setPourList(List<PourBean> pourList) {
		this.pourList=pourList;
	}
	public List<PourBean> getPouList(){
		return pourList;
	}
	public void Addpour(PourBean pb){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.save(pb);
			tx.commit();
			System.out.println("�����Ѿ��ύ");
		}catch(Exception e){
			tx.rollback();
			System.out.println("����û���ύ");
		}finally{
			session.close();
		}
	}
	/*
	 * ���Խ��
	 * 
	 */
	public void resluts(ResultsBean RB){
		
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			session.save(RB);
			tx.commit();
			
		}catch(Exception e){
			tx.rollback();

		}finally{
			session.close();
		}
	
	}
	
	/*
	 * ���Խ����Ӧ�Ļ����ѯ
	 */
	public void Text_results(int test_id,int  test_sum){
		Transaction tx=null;
		Session session=null;
		HibernateUtil hibernate=new HibernateUtil();
		try{
			session=(Session)hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("from Text_answer_results tab where  tab.test_id = ? and tab.test_sum_Weight=? ");
			query.setInteger(0, test_id);
			query.setInteger(1, test_sum);
		//	Query query=session.createQuery("from PourBean ");
			setTest_results_List(query.list());
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	
	public void setTest_results_List(List<Text_answer_results> test_results_List){
		this.test_results_List=test_results_List;
	}
	public List<Text_answer_results> getTest_results_List(){
		return test_results_List;
	}
}
