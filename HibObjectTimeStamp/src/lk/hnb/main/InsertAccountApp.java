package lk.hnb.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.hnb.model.BankAccount;
import lk.hnb.model.Customer;
import lk.hnb.utils.HibernateUtil;

public class InsertAccountApp {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		Long id = null;
		BankAccount account = null;
		try {
			session = HibernateUtil.getSession();
			
			if(session!=null)
				transaction = session.beginTransaction();
			if(transaction!=null) {
				account = new BankAccount();
				account.setBalance(50000.00);
				account.setHolderName("Hashan");
				account.setType("Saving");
				id = (Long) session.save(account);
				flag = true;
			}
		} catch(HibernateException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(flag) {
				transaction.commit();
				System.out.println("Customer added with ID :"+id);
			}
			else
			{
				transaction.rollback();
				System.out.println("Unable to save the cutomer..");
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
