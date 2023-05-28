package lk.iqrah.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lk.iqrah.model.MobileCustomer;

public class InsertRecordApp {
		public static void main(String[] args) {
			SessionFactory sessionFactory = null;
			Session session = null;
			Transaction transaction = null;
			boolean flag = false;
			Integer id = null;
			MobileCustomer customer = null;
			
			try {
				sessionFactory = new Configuration().configure()
				.addAnnotatedClass(MobileCustomer.class)
				.buildSessionFactory();
				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				
				if(transaction != null) {
					customer.setCallerTune("VantheMatharam");
					customer.setCname("Ravi");
					customer.setPhoneNo(1234567891L);
					
					id = (Integer) session.save(customer);
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
				
				session.close();
				sessionFactory.close();
//				HibernateUtil.closeSession(session2);
//				HibernateUtil.closeSessionFactory();
			}
			
		}
}
