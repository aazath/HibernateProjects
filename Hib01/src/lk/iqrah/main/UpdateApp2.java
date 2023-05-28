package lk.iqrah.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.iqrah.model.StudentAutoMapping;
import lk.iqrah.utils.HibernateUtil;

public class UpdateApp2 {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		StudentAutoMapping student = session.get(StudentAutoMapping.class, 12);
		try {
			if(session!=null)
				transaction = session.beginTransaction();
			
			if(transaction!=null)
			{
				student.setSage(10);
				student.setSaddress("Colombo");
				
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
