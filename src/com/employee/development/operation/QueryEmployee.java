/**
 * QueryEmployee
 * 
 * The purpose of this class is to query Employee
 * data from the DataBase
 * 
 * @author	Brook Worku
 * @date	02/27/2018
 */

package com.employee.development.operation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.development.entity.Employee;

public class QueryEmployee {

	public static void main(String[] args) {
		int cntr;
		// Create SessionFactory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		try {
			// create session object
			Session session = factory.getCurrentSession();
			
			// begin the session
			session.beginTransaction();
			// SQL Operation
			
			// Retrieve 
			List<Employee> theEmployee = session.createQuery("from Employee e where "
					+ "e.firstName = 'Fekadu'").getResultList();
			
			// Print out
			for(Employee emp: theEmployee) {
				System.out.println(emp + "\n");
			}
			
			// flush session 
			session.getTransaction().commit();
		}finally {
		// close the SessionFactory
		factory.close();
		}
	} // end main

} // end QueryEmployee
