package lk.hnb.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import lk.hnb.model.BankAccount;
import lk.hnb.utils.HibernateUtil;

public class UpdateAccountApp {

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
				Query<BankAccount> query = session.createQuery("UPDATE lk.hnb.model.BankAccount SET balance=balance+:deposit WHERE accNo=:acNo");
				
				System.out.println("Enter the Account No :");
				Long acNo = scanner.nextLong();
				System.out.println("Enter deposit amount :");
				Double amount = scanner.nextDouble();
				
				query.setParameter("acNo", acNo);
				query.setParameter("deposit", amount);
				
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
				System.out.println("Balance updated..");
			} else {
				transaction.rollback();
				System.out.println("Unable to update the balance details..");
				System.exit(0);
			}
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}
	}

}
