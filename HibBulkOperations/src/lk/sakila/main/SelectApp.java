package lk.sakila.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import lk.sakila.model.Actor;
import lk.sakila.utils.HibernateUtil;

public class SelectApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null) {
				Query<Actor> query = session.createQuery("FROM lk.sakila.model.Actor");
				List<Actor> actors = query.list();
				actors.forEach(System.out::println);
			}
								
		} catch(HibernateException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
