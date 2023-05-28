package lk.hnb.main;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import lk.hnb.model.BankAccount;
import lk.hnb.utils.HibernateUtil;

public class SelectQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				NativeQuery<Object[]> nativeQuery = session.createNativeQuery("SELECT holderName, balance FROM bankaccount WHERE balance>=? AND balance<=?");
				nativeQuery.setParameter(1, 30000);
				nativeQuery.setParameter(2, 60000);
				
				List<Object[]> accounts = nativeQuery.getResultList();
				System.out.println("HolderName\tBalance");
				accounts.forEach(row->{
					for(Object obj :row)
						System.out.print(obj +"\t");
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
