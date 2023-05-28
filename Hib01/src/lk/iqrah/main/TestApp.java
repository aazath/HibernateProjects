package lk.iqrah.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import lk.iqrah.model.Student;

public class TestApp {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student();
		student.setSid(10);
		student.setSname("Amila");
		student.setSage(10);
		student.setSaddress("Kandy");
		
		
		session.save(student);
		transaction.commit();
		
	}

}
