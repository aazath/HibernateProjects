package lk.hnb.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import lk.hnb.model.BankAccount;
import lk.hnb.utils.HibernateUtil;

public class DeleteAccountApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Transaction transaction = null;
		Scanner scanner = null;
		int rowAffected = 0;
		try {
			session = HibernateUtil.getSession();

			if (session != null)
				transaction = session.beginTransaction();
			if (transaction != null) {
				scanner = new Scanner(System.in);
				Query query = session.createQuery("DELETE FROM lk.hnb.model.BankAccount WHERE accNo=:acNo");
				
				System.out.println("Enter the Account No :");
				Long acNo = scanner.nextLong();
								
				query.setParameter("acNo", acNo);
				
				rowAffected = query.executeUpdate();
				flag = true;
				}
			
		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Account deleted..");
			} else {
				transaction.rollback();
				System.out.println("Unable to delete the account..");
				System.exit(0);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}
	}

}
