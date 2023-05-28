package lk.hnb.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import lk.hnb.model.BankAccount;
import lk.hnb.model.Customer;
import lk.hnb.utils.HibernateUtil;

public class PartialLoading {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Long id = null;
		BankAccount account = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				Query<Object[]> query = session
						.createQuery("SELECT accNo, balance FROM lk.hnb.model.BankAccount WHERE type IN(:type1)");
				query.setParameter("type1", "Saving");
				List<Object[]> accounts = query.list();

				System.out.println("AccNo\tBal");
				accounts.forEach(row -> {
					for (Object obj : row) {
						System.out.print(obj + "\t");
					}
					System.out.println();
				});
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();

		}
	}

}
