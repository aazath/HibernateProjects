package lk.iqrah.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.iqrah.model.PersonInfo;
import lk.iqrah.util.HibernateUtil;

public class SelectRecordApp {
	public static void main(String[] args) {
		Session session = null;
		boolean flag = false;
		
		try {
			session = HibernateUtil.getSession();
			if(session != null) {
				int id = 2;
				PersonInfo personInfo = session.get(PersonInfo.class, id);
				if(personInfo!=null) {
					System.out.println(personInfo);
				}
				else
					System.out.println("No record found..");
			}
		} catch(HibernateException e)
		{
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
					
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
