/**
 * SaveEmployee
 * 
 * The purpose of this class is to save an Employee object
 * into DB
 * 
 * @author Brook Worku
 * @date	02/23/2018
 */

package com.employee.development.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.employee.development.entity.Employee;

public class SaveEmployee {

	public static void main(String[] args) {
		// Create SassionFactory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		try {
			// Begin the session
			session.beginTransaction();
			System.out.println("Begin Transaction...");

			
			// Create Employee object
			Employee emp = new Employee("Dj", "Worku", "FW Furniture");
			
			// Save Object to db
			session.save(emp);
			System.out.println("Saving the object to db");
			
			// Flush session	
			session.getTransaction().commit();
		} finally {
			// close SassionFactory
			factory.close();
			System.out.println("Close the connection");
		}
		

	} // mail

}// end SaveEmployee
