package lk.hnb.main;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import lk.hnb.model.InsurancePolicy;
import lk.hnb.utils.HibernateUtil;


public class InsertApp {
	
public static void main(String[] args) {
	
	Session session = null;
	Transaction transaction = null;
	boolean flag = false;
	Long id = null;
	
	try {
		
		session = HibernateUtil.getSession();
		if(session != null) {
			transaction = session.beginTransaction();
		}
		
		if(transaction != null) {
			InsurancePolicy policy = new InsurancePolicy();
			policy.setCompany("LIC");
			policy.setPolicyName("Life Insurance");
			policy.setPolicyType("Yearly");
			policy.setTenure(5);
			
			id = (Long) session.save(policy);
			flag = true;
		}
	} catch(HibernateException e)
	{
		e.printStackTrace();
	}
	catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(flag)
		{
			transaction.commit();
			System.out.println("Saved Successfully with ID :"+id);
		}
		else
		{
			transaction.rollback();
			System.out.println("Did not saved...");
		}
		
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}
	
}
}
