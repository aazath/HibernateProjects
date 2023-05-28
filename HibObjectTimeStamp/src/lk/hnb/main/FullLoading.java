package lk.hnb.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import lk.hnb.model.BankAccount;
import lk.hnb.model.Customer;
import lk.hnb.utils.HibernateUtil;

public class FullLoading {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Long id = null;
		BankAccount account = null;
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null) {
				Query<BankAccount> query = session.createQuery("FROM lk.hnb.model.BankAccount");
				List<BankAccount> accounts = query.list();
				accounts.forEach(System.out::println);
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
