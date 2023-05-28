package lk.hnb.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.hnb.model.BankAccount;
import lk.hnb.utils.HibernateUtil;

public class UpdateAccountApp {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		Long id = 2L;
		BankAccount account = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();
			if (transaction != null) {
				account = session.get(BankAccount.class, id);
				if (account != null) {
					account.setBalance(account.getBalance() + 10000.00);
					flag = true;
				}
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Account updated...");
				System.out.println("Account Opening date :" + account.getOpeningDate());
				System.out.println("Account Last updated on :" + account.getLastUpdate());
				System.out.println("Account Version count :" + account.getCount());
				System.out.println("Account Current Balance :" + account.getBalance());
			} else {
				transaction.rollback();
				System.out.println("Unable to update the Account details..");
				System.exit(0);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}
	}

}
