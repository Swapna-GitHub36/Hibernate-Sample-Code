package com.gl.hibernateexample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.gl.hibernateexample.entity.Employee;
import com.gl.hibernateexample.util.HibernateUtil;

public class HibernateExampleUsingXML {
	private static StandardServiceRegistry registry;
	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		Employee emp = new Employee(129, "Ram", 6000, "643113245");

		registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//create MetaDataSources
		MetadataSources sources = new MetadataSources(registry);

		//create MetaData
		Metadata metadata = sources.getMetadataBuilder().build();

		//create SessionFactory
		sessionFactory = metadata.getSessionFactoryBuilder().build();
		Transaction transaction = null;
		Session session = null;
		try {
			// open session
			session = HibernateUtil.getSessionFactory().openSession();
			// start transaction
			transaction = session.beginTransaction();
			// save employee object in to db
			session.save(emp);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

		// display the employees
		try {
			// open session
			session = HibernateUtil.getSessionFactory().openSession();
			// start transaction
			transaction = session.beginTransaction();
			// select * from employee;
			List<Employee> employeeList = session.createQuery("from Employee", Employee.class).list();
			// display the list
			for (Employee e : employeeList) {
				System.out.println(e.getEmpId() + e.getEmpName() + e.getEmpSalary() + e.getEmpMobno());
			}

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
