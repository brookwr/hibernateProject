/**
 * RetrieveEmployee
 * 
 * The purpose of this class is to retrieve an object from
 * the db
 * 
 * @author	Brook Worku
 * @date	02/27/2018
 */

package com.employee.development.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.development.entity.Employee;

public class RetrieveEmployee {

	public static void main(String[] args) {
		// Create SessionFactory object
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// Create Session object 
		Session session = factory.getCurrentSession();
		
		try {
			// begin session
			session.beginTransaction();
			
			// SQL Operation
			
			// Retrieve the object
			Employee emp = new Employee("Fekadu", "Worku", "FW Furniture");
			
			session.save(emp);
			
			
			// flush session
			session.getTransaction().commit();
			
		//************ Retrieve the saved object
			// create a session
			session = factory.getCurrentSession();
			
			// begin a new session 
			session.beginTransaction();
			
			// get Employee by pk
			Employee rEmp = session.get(Employee.class, emp.getEmployeeId());
			
			// print out the Employee
			System.out.println("**********************Printing out!!!!!!******************");
			System.out.println(rEmp);
			// flush session
			session.getTransaction().commit();
		} finally {
			// Close connection
			factory.close();
		}
		

	}// end main

} // end RetrieveEmployee
