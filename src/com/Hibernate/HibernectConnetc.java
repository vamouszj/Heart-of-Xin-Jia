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
	 * 登陆查询
	 */
	public void Land(String string){
	    Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			/*
			 * 查询所有实体对象，
			 * 其中 from后边的不是表名是对象名。
			 */
			Query query=session.createQuery("from LangBean LB where LB.account=?");           //查询出实体类的全部对象
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
			 * 查询所有实体对象，
			 * 其中 from后边的不是表名是对象名。
			 */
			Query query=session.createQuery("from LangBean LB where LB.id=?");           //查询出实体类的全部对象
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
	 * 注册
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
			System.out.println("事物没有提交成功");
			return false;
		}finally{
			session.close();
		}
		return true;
	}
	
	public void Count_Register(){           //统计
		 Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			Query query=session.createQuery("select count(RB.R_id) from RegisterBean RB");           //查询出实体类的全部对象
			listCount=query.list();
			
			tx.commit();
		}catch(Exception e){
			tx.rollback();
		}finally{
			session.close();
		}
	}
	
	public void Register_all(int pagenum,int pagesize){             //分页查询
	    Transaction tx=null;
		 Session session=null;
		 HibernateUtil hibernate =new HibernateUtil();
		try{
			session=(Session) hibernate.getSession();
			tx=session.beginTransaction();
			
			/*
			 * 查询所有实体对象，
			 * 其中 from后边的不是表名是对象名。
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
	public void Condition_REGISTER(String User_name){          //用户个人信息显示
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
	public void Find_condition_Register(int re_id){                  //查询对象
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
	public void Del_Register(RegisterBean RB){             //删除
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
	 * 文章
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
	
	public void ModArticle(ArticleBeam AB){                          //修改
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
	
	public void DelActicle(ArticleBeam AB){                             //删除
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
		//	System.out.println("删除成功");
		}
	}
	public void AddArtcile(ArticleBeam AB){                                   //添加
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
	 * 音乐
	 */
	
	public void Music(){              //查找
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
	public void DelMusic(MusicInfo MI){                 //删除音乐
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
	
	public void AddMusic(MusicInfo MI){                         //添加音乐
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
	
	//测试
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
	//统计测试题数目
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
	//分页
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
	
	public void Add_Text(TextBean test){                  //添加测试题
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
	
	public void Find_Condition_Text(int text_id){                //条件查询
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
	public void UpdateText(TextBean test){      //跟新测试人数 
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
	//删除测试题
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
	
	
	
	//试题题目
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
	public void Add_subject(SubjectBean SB){               //添加。
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
	public void Del_Subject(SubjectBean SB){               //删除
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
	//测试题选项
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
	public void Del_Power(PowerBean PB){                 //删除选项
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
	 * 交互
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
			System.out.println("事物已经提交");
		}catch(Exception e){
			tx.rollback();
			System.out.println("事物没有提交");
		}finally{
			session.close();
		}
	}
	/*
	 * 测试结果
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
	 * 测试结果对应的话语查询
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
