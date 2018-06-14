/**
 * DeleteEmployee
 * 
 * The purpose of this class is to perform delete transaction 
 * from DB
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

public class DeleteEmployee {

	public static void main(String[] args) {
		// Create Session Factory object
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
			// Create Session Object
			Session session = factory.getCurrentSession();
			
			try {
			//************** Delete Employee  *********************
				
				// begin session
				session.beginTransaction();
				
				session.createQuery("delete Employee e where e.employeeId = 8")
				.executeUpdate();
				
				// flush session
				session.getTransaction().commit();
				
			//****************************
				
			//********************* Update Employee ****************
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.createQuery("update Employee e set e.companyName = 'FW Furniture' where e.employeeId = 7")
					.executeUpdate();
			
			session.getTransaction().commit();
			
			//************* Query Employee ************************
				
				session = factory.getCurrentSession();
				session.beginTransaction();
				
				List<Employee> theEmployee = session.createQuery("from Employee e").getResultList();
				
				for(Employee emp: theEmployee) {
					System.out.println(emp + "\n");
				}
				
				session.getTransaction().commit();
				
			} finally {
				// close factory
				factory.close();
			}
	} // end main

} // end DeleteEmployee
