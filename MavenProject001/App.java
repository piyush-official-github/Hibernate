package com.MavenProject001;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Project started .....");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();

		Student student1 = new Student();
		student1.setId(121);
		student1.setName("Piyush");
		student1.setCity("Indore");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("Java Backend");
		certificate1.setDuration("100 days");
		student1.setCertificate(certificate1);
		
		Student student2 = new Student();
		student2.setId(123);
		student2.setName("Kanishka");
		student2.setCity("salakanpur");
		
		Certificate certificate2 = new Certificate();
		certificate2.setCourse("Java Backend");
		certificate2.setDuration("100 days");
		student2.setCertificate(certificate2);
		
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student1);
		s.save(student2);
		
		tx.commit();
		s.close();
		factory.close();
		
		
		
	}
}
