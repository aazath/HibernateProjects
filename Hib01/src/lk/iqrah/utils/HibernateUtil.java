package lk.iqrah.utils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import lk.iqrah.model.Student2;
import lk.iqrah.model.StudentAutoMapping;

public class HibernateUtil {
	
	private static Session session = null;
	private static SessionFactory sessionFactory = null;
	
	static {
		sessionFactory = new Configuration().configure().addAnnotatedClass(Student2.class).buildSessionFactory();
	}
	
	public static Session getSession() {
		if(session == null)
			session = sessionFactory.openSession();
		return session;
	}
	
	public static void closeSession(Session session) {
		if(session!=null)
			session.close();
	}
	
	public static void closeSessionFactory() {
		if(sessionFactory!=null)
			sessionFactory.close();
	}
}
