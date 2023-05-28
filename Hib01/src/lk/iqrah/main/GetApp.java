package lk.iqrah.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.iqrah.model.StudentAutoMapping;
import lk.iqrah.utils.HibernateUtil;

public class GetApp {

	public static void main(String[] args) {
		
		Session session = null;
		Integer id =12;
		
		try {
			session = HibernateUtil.getSession();
			
			StudentAutoMapping student = session.get(StudentAutoMapping.class, id);
			System.out.println(student);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
		
	}

}
