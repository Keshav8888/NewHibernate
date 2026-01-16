package com.keshav.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.keshav.entity.Employee;
 
public class EmployeeRunner{
	
	public static void main(String[] args) {
		
		Employee emp = new Employee("Pintu","Male",40500);
		
//      using "Configuration"
//		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
// 		Configuration single line(Method chaining)
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
//		using "StandardServiceRegistry"
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//		Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
//		SessionFactory sessionFactory = metadata.buildSessionFactory();
		
// 		StandardServiceRegistry single line(Method chaining)
		SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build()).getMetadataBuilder().build().buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.persist(emp);;
		tx.commit();
		
//		get method(now deprecated)
//		Employee employee = session.get(Employee.class,5);
//		System.out.println(employee);
//		
//		Employee employee = session.get(Employee.class,10);   //it will give null as 10th Object is not found in database
//		System.out.println(employee);
		
		//Now find is used instead of get
//		Employee employee = session.find(Employee.class,10);   //it will give null
//		System.out.println(employee);
		
//		Employee employee = session.find(Employee.class,3);
//		System.out.println(employee);
		
//		load method
//		Employee employee = new Employee();
//		session.load(employee,4);
//		System.out.println(employee);
		
//		session.load(employee,10);   //it will give ObjectNotFoundException as 10th Object is not found in database
//		System.out.println(employee);

	}
}