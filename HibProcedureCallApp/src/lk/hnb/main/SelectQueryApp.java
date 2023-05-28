package lk.hnb.main;

import java.util.List;
import java.util.Scanner;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.procedure.ProcedureCall;
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
				ProcedureCall procedureCall = session.createStoredProcedureCall("P_GET_ACCOUNTS_BY_TYPE");
				String accType="Saving";
				
				procedureCall.registerParameter(1, String.class, ParameterMode.IN).bindValue(accType);
				List<Object[]> accounts = procedureCall.getResultList();
				System.out.println("AccNo\tName\tBal");
				accounts.forEach(row ->{
					for(Object obj : row)
						System.out.print(obj + "\t");
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
