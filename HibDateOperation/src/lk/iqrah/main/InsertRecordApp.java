package lk.iqrah.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.iqrah.model.PersonInfo;
import lk.iqrah.util.HibernateUtil;

public class InsertRecordApp {
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		Integer id = null;
		
		try {
			
			session = HibernateUtil.getSession();
			if(session != null) {
				transaction = session.beginTransaction();
			}
			
			if(transaction != null) {
				PersonInfo personInfo = new PersonInfo();
				personInfo.setPname("Ayana");
				personInfo.setDob(LocalDate.of(2014, 7, 25));
				personInfo.setDom(LocalDateTime.of(2013, 9, 13, 17, 30));
				personInfo.setDoj(LocalTime.of(10, 30));
				
				id = (Integer) session.save(personInfo);
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
				System.out.println("Person Saved Successfully with ID :"+id);
			}
			else
			{
				transaction.rollback();
				System.out.println("Person did not saved...");
			}
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}
}
