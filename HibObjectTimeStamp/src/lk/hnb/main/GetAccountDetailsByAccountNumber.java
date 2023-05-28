package lk.hnb.main;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import lk.hnb.model.BankAccount;
import lk.hnb.model.Customer;
import lk.hnb.utils.HibernateUtil;

public class GetAccountDetailsByAccountNumber {

	public static void main(String[] args) {
		Session session = null;
		Boolean flag = false;
		Long id = null;
		Scanner scanner = null;
		try {
			session = HibernateUtil.getSession();

			if (session != null) {
				Query<BankAccount> query = session.createQuery("FROM lk.hnb.model.BankAccount WHERE accNo =:id");
				System.out.println("Enter the Account Number :");
				scanner = new Scanner(System.in);
				Long acNo = scanner.nextLong();
				query.setParameter("id", acNo);
				
				Optional<BankAccount> optional = query.uniqueResultOptional();
				if(optional.isPresent())
				{
					BankAccount bankAccount = optional.get();
					System.out.println(bankAccount);
				}
				else {
					System.out.println("No bank account exists with the account no :"+acNo);
				}
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
			
		}
	}

}
