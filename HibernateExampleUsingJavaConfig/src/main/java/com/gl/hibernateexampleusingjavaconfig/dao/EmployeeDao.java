package com.gl.hibernateexampleusingjavaconfig.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gl.hibernateexampleusingjavaconfig.entity.Employee;
import com.gl.hibernateexampleusingjavaconfig.util.HibernateUtil;

public class EmployeeDao {
	Transaction transaction = null;

	public void insertEmployee(Employee emp) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();
			// save employee object
			session.save(emp);
			// commit transaction
			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

	}// insert employee

	public List<Employee> selectAllEmployees() {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			return session.createQuery("from Employee", Employee.class).list();
		}

	}

	public Employee searchAnEmployee(Long sempid){
		
		Employee empById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {	
					// start the transaction
					transaction = session.beginTransaction();
					//get entity from database
					//select * from employee where empid = ?
					empById = session.get(Employee.class, sempid);
					if(empById!=null) {
						
						System.out.println("Employee details are = " + empById.getEmpName());
					}
				}catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}

					e.printStackTrace();
				}
		return empById;	
	}
	
	public void deleteEmployee(Class<?> type,Serializable empid) {
		Transaction transaction1 = null;
		try (Session session1 = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction1 = session1.beginTransaction();
			Employee emp = session1.get(Employee.class, empid);
			System.out.println(emp);
			if(emp!=null) {
				session1.remove(emp);
				System.out.println("Employee deleted successfully");
			}
			transaction1.commit();
			
		}catch (Exception e) {
			if (transaction1 != null) {
				transaction1.rollback();
			}

			e.printStackTrace();
		}
		}
	public void updateEmployee(Long empid,float empSalary) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			//session.saveOrUpdate(emp);
			
			//get entity from database
			Employee updatingEmp = session.get(Employee.class, empid);
			System.out.println(updatingEmp);
			//do changes
			updatingEmp.setEmpSalary(empSalary);
			//update the Employee object
			session.saveOrUpdate(updatingEmp);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}
}
