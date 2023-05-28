package lk.hnb.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.hnb.model.BankAccount;
import lk.hnb.model.Customer;
import lk.hnb.utils.HibernateUtil;

public class SelectBankAccountApp {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Long id = null;
		BankAccount account = null;
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null)
				account = session.get(BankAccount.class, 2L);
				flag = true;
				if(flag)
					System.out.println(account);
		
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
