package com.tech.rest.client.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "EMPLOYEELIST")
@XmlAccessorType(XmlAccessType.NONE)
public class EmployeeList {
	
	@XmlElement(name="EMPLOYEE")
	private List<EmployeeDetails> employeeDetails;

	/**
	 * @return the employeeDetails
	 */
	public List<EmployeeDetails> getEmployeeDetails() {
		return employeeDetails;
	}

	/**
	 * @param employeeDetails the employeeDetails to set
	 */
	public void setEmployeeDetails(List<EmployeeDetails> employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	
}
