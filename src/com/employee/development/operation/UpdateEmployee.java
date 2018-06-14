/**
 * UpdateEmployee
 * 
 * The purpose of this class is to update the 
 * employee object
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

public class UpdateEmployee {

	public static void main(String[] args) {
		// Create SessionFactory object
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
			// create session object
			Session session = factory.getCurrentSession();
			
		try {
			// begin session
			session.beginTransaction();
			
			session.createQuery("update Employee e set e.companyName = 'Fetan' where e.employeeId = 6")
			.executeUpdate();
			
			// flush session
			session.getTransaction().commit();
			
			
			// create session object
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			List<Employee> theEmployee = session.createQuery("from Employee e where e.companyName = 'Fetan'").getResultList();
			
			for(Employee emp: theEmployee) {
				System.out.println(emp);
			}
			
			session.getTransaction().commit();
			
		} finally {
			// Close SessionFactory object
			factory.close();
		}
		
	} // end main

} // end UpdateEmployee
