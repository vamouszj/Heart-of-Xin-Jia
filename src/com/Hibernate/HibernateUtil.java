package com.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static SessionFactory factory=null;
	private Configuration cfg;
	public  HibernateUtil(){
	    cfg=new Configuration().configure();
		factory=cfg.buildSessionFactory();
	}
	public static Session getSession(){
		return (Session) factory.openSession();
	}
}
