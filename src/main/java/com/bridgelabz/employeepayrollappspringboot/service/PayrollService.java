package com.bridgelabz.employeepayrollappspringboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollappspringboot.DTO.PayrollDto;
import com.bridgelabz.employeepayrollappspringboot.email.EmailService;
import com.bridgelabz.employeepayrollappspringboot.exception.PayrollException;
import com.bridgelabz.employeepayrollappspringboot.model.PayrollModel;
import com.bridgelabz.employeepayrollappspringboot.repository.PayrollRepository;
import com.bridgelabz.employeepayrollappspringboot.util.TokenUtil;

@Service
public class PayrollService implements IPayrollService {

	@Autowired
	private PayrollRepository repo;
	@Autowired
	private TokenUtil tokenUtil;
	@Autowired
	EmailService email;

	public String welcomeMsg() {
		return "Welcome to Employee Payroll App";
	}

//	Adding details
	@Override
	public PayrollModel addEmployeeDetails(PayrollDto payrollDto) {
		PayrollModel payrollModel = new PayrollModel(payrollDto);
		String token = tokenUtil.createToken(payrollModel.getEmployeeId());
		email.sendEmail(payrollModel.getEmail(), "Test Mail",
				"Hii...." + payrollModel.getName() + " your details are added!\n\n Name:  " + payrollModel.getName()
						+ "\n Gender:  " + payrollModel.getGender() + "\n Email:  " + payrollModel.getEmail()
						+ "\n Profile Pic:  " + payrollModel.getProfilePic() + "\n Salary:  " + payrollModel.getSalary()
						+ "\n Start Date:  " + payrollModel.getStartDate() + "\n Notes:  " + payrollModel.getNotes()
						+ "\n Token: " + token);
		return repo.save(payrollModel);
	}

//	Show all Details
	@Override
	public List<PayrollModel> getAllDetails() {
		return repo.findAll();
	}

//	Update Data By ID
	@Override
	public PayrollModel updatedetails(PayrollDto payrollDto, int id) {
		PayrollModel payrollModel = new PayrollModel(payrollDto);
		Optional<PayrollModel> details = repo.findById(id);
		return payrollModel;
	}

//	Delete data by ID
	@Override
	public String deleteDetails(int id) {
		PayrollModel payrollModel = this.detailsGetById(id);
		repo.deleteById(id);
		email.sendEmail(payrollModel.getEmail(), "Test Mail", "Hii....! Your details has been deleted!");
		return "Delete";
	}

//	details get by ID
	@Override
	public PayrollModel detailsGetById(int id) {
		Optional<PayrollModel> details = repo.findById(id);
		return details.get();
	}

	@Override
	public List<PayrollModel> getEmployeePayrollByDepartment(String department) {
		return repo.findEmployeesByDepartment(department);
	}

	@Override
	public String createRecordAndToken(PayrollDto payrollDto) {
		PayrollModel payrollModel = null;
		payrollModel = new PayrollModel(payrollDto);
		repo.save(payrollModel);
		String token = tokenUtil.createToken(payrollModel.getEmployeeId());
		email.sendEmail(payrollModel.getEmail(), "Test Mail",
				"Hii...." + payrollModel.getName() + " your details are added!\n\n Name:  " + payrollModel.getName()
						+ "\n Gender:  " + payrollModel.getGender() + "\n Email:  " + payrollModel.getEmail()
						+ "\n Profile Pic:  " + payrollModel.getProfilePic() + "\n Salary:  " + payrollModel.getSalary()
						+ "\n Start Date:  " + payrollModel.getStartDate() + "\n Notes:  " + payrollModel.getNotes()
						+ "\n Token: " + token);
		return token;

	}

	@Override
	public PayrollModel getRecordByToken(String token) {
		int id = tokenUtil.decodeToken(token);
		PayrollModel payrollModel = repo.findById(id).get();
		return payrollModel;
	}

	@Override
	public PayrollModel updateRecordByToken(String token, PayrollDto payrollDto) {
		int id = tokenUtil.decodeToken(token);
		PayrollModel payrollModel = this.detailsGetById(id);
		payrollModel.updatePersonData(payrollDto);
		return repo.save(payrollModel);

	}

	@Override
	public PayrollModel deletePersonRecordByToken(String token) {
		int id = tokenUtil.decodeToken(token);
		if (repo.findById(id).isPresent()) {
			PayrollModel payrollModel = repo.findById(id).get();
			repo.deleteById(id);
			email.sendEmail(payrollModel.getEmail(), "Test Mail", "Hii....! Your details has been deleted!");
			return payrollModel;
		} else {
			throw new PayrollException("Invalid token ");
		}

	}
}
