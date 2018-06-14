/**
 * Employee
 * 
 * The purpose of this class is to represent an Employee
 * 
 * @author	Brook Worku
 * @date	02/23/2018
 */

package com.employee.development.entity;

import java.util.InputMismatchException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@SequenceGenerator(name = "emp_seq", sequenceName = "emp_seq", allocationSize = 1)
public class Employee {
	// Attributes
	
	@Id
	@Column(name = "employee_Id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	private int employeeId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "company")
	private String companyName;
	
	
	/**
	 * Employee
	 * 
	 * The purpose of this ng-arg constructor is to initialize 
	 * all the attributes to their default value
	 *
	 */
	public Employee() {
		
	} // end Employee
	
	/**
	 * Employee
	 * 
	 * The purpose of this overloaded is to initialize all the 
	 * attributes
	 * 
	 * @param nEmpId	-employee id
	 * @param nFName	-the first name
	 * @param nLname	- the last name
	 * @param nComName	-the company name
	 */
	public Employee(String nFName, String nLName, String nComName) {
		setFirstName(nFName);
		setLastName(nLName);
		setCompany(nComName);
		
	} // Employee

	
	
	
	/**
	 * setEmployeeId
	 * 
	 * the purpose of this method is to modify the value of the 
	 * employee id
	 * 
	 * @param newId
	 */
	public void setEmployeeId(int newId) {
		if(newId <= 0) {
			throw new InputMismatchException("Invalid Number");
		}
		employeeId = newId;
	} // end setEmployeeId
	
	/**
	 * setFirstName
	 * 
	 * the purpose of this method is to modify the value of the
	 * first name
	 * 
	 * @param newFirstName
	 */
	public void setFirstName(String newFirstName) {
		firstName = newFirstName;
	} // end setFirstName
	
	
	/**
	 * setLastName
	 * 
	 * the purpose of this method is to modify the value of the last
	 * name
	 * 
	 * @param newLastName
	 */
	public void setLastName(String newLastName) {
		lastName = newLastName;
	} // end setLastName
	
	
	/**
	 * setCompanyName
	 * 
	 * the purpose of this method is to modify the name of the 
	 * company
	 * 
	 * @param newCompany
	 */
	public void setCompany(String newCompany) {
		companyName = newCompany;
	}// end setCompany
	
	
	
	
	/**
	 * getEmployeeId
	 * 
	 * the purpose of this method is to return Employee id 
	 * 
	 * @return	employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	} // end getEmployeeId
	
	
	
	/**
	 * toString
	 * 
	 * the purpose of this method is to print out an object
	 * 
	 */
	public String toString() {
		return String.format("Employee Id:\t%d%nFirst Name:\t%s%nLast Name:\t%s%nCompany Name:\t%s", 
				employeeId, firstName, lastName, companyName);
	} // end toString
	
	
	
	
	
	
} // end Employee
