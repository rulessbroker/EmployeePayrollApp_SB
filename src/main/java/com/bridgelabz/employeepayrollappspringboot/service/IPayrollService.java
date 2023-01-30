package com.bridgelabz.employeepayrollappspringboot.service;

import java.util.List;

import com.bridgelabz.employeepayrollappspringboot.DTO.PayrollDto;
import com.bridgelabz.employeepayrollappspringboot.model.PayrollModel;

public interface IPayrollService {
	public String welcomeMsg();

	public PayrollModel addEmployeeDetails(PayrollDto payrollDto);

	public List<PayrollModel> getAllDetails();

	public PayrollModel updatedetails(PayrollDto payrollDto, int id);

	public String deleteDetails(int id);

	public PayrollModel detailsGetById(int id);
	
	public List<PayrollModel> getEmployeePayrollByDepartment(String department);

	String createRecordAndToken(PayrollDto payrollDto);

	PayrollModel getRecordByToken(String token);

	PayrollModel updateRecordByToken(String token, PayrollDto payrollDto);

	PayrollModel deletePersonRecordByToken(String token);

}
