package com.bridgelabz.employeepayrollappspringboot.model;

import java.util.List;

public class PayrollModel {
	private int employeeId;
	private String name;
	private String profilePic;
	private String gender;
	private String email;
	private List<String> department;
	private long salary;
	private String notes;
	private String startDate;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getDepartment() {
		return department;
	}

	public void setDepartment(List<String> department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	@Override
	public String toString() {
		return "PayrollModel [employeeId=" + employeeId + ", name=" + name + ", profilePic=" + profilePic + ", gender="
				+ gender + ", email=" + email + ", department=" + department + ", salary=" + salary + ", notes=" + notes
				+ ", startDate=" + startDate + "]";
	}

}
