package lk.iqrah.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.iqrah.model.Student2;
import lk.iqrah.utils.HibernateUtil;

public class InsertRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		String id = null;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null)
				transaction = session.beginTransaction();
			
			if(transaction != null) {
				Student2 student = new Student2();
				student.setSname("Aafiya");
				student.setSaddress("Kalmunai");
				student.setSage(4);
				
				id = (String) session.save(student);
				flag = true;
			}
		} catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag)
			{
				transaction.commit();
				System.out.println("Student Saved Successfully with ID :"+id);
			}
			else
			{
				transaction.rollback();
				System.out.println("Student did not saved...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
