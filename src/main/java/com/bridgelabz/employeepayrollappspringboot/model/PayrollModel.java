package com.bridgelabz.employeepayrollappspringboot.model;

import java.util.List;

import com.bridgelabz.employeepayrollappspringboot.DTO.PayrollDto;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "employee_payroll_data")
public class PayrollModel {
	@Id
	@Column(name = "employee_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int employeeId;
	@Column(name = "name")
	private String name;
	private String profilePic;
	private String gender;
	private String email;
	@ElementCollection
	@CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
	@Column(name = "department")
	private List<String> department;
	private long salary;
	private String notes;
	private String startDate;

	public PayrollModel(PayrollDto payrollDto) {
		this.updatePersonData(payrollDto);
	}

	public void updatePersonData(PayrollDto payrollDto) {
		this.name = payrollDto.getName();
		this.profilePic = payrollDto.getProfilePic();
		this.gender = payrollDto.getGender();
		this.email = payrollDto.getEmail();
		this.department = payrollDto.getDepartment();
		this.salary = payrollDto.getSalary();
		this.notes = payrollDto.getNotes();
		this.startDate = payrollDto.getStartDate();

	}

	public PayrollModel() {

	}

}
