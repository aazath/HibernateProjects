package lk.iqrah.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.iqrah.model.StudentAutoMapping;
import lk.iqrah.utils.HibernateUtil;

public class UpdateApp {

	public static void main(String[] args) {
		
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		
		try {
			session = HibernateUtil.getSession();
			if(session!=null)
				transaction = session.beginTransaction();
			
			if(transaction!=null)
			{
				StudentAutoMapping student = new StudentAutoMapping();
				student.setSid(12);
				student.setSname("Ameen");
				student.setSage(10);
				student.setSaddress("Kalmunai");
				
				session.update(student);
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(flag) {
				transaction.commit();
				System.out.println("Student Updated");
			}
			else {
				transaction.rollback();
				System.out.println("Unable to update the student");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
		
		
	}

}
