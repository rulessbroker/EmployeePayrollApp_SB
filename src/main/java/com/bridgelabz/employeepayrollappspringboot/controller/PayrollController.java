package com.bridgelabz.employeepayrollappspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollappspringboot.DTO.PayrollDto;
import com.bridgelabz.employeepayrollappspringboot.DTO.ResponseDTO;
import com.bridgelabz.employeepayrollappspringboot.model.PayrollModel;
import com.bridgelabz.employeepayrollappspringboot.service.IPayrollService;

import jakarta.validation.Valid;

@RestController
public class PayrollController {
	@Autowired
	IPayrollService service;

//	Welcome message
	@GetMapping("/app")
	public String welcomeEmpMsg() {
		return service.welcomeMsg();
	}

//	Add details
	@PostMapping("/addDetails")
	public PayrollModel addDetails(@Valid @RequestBody PayrollDto payrollDto) {
		PayrollModel empData = service.addEmployeeDetails(payrollDto);
		return empData;
	}

//	show all data
	@GetMapping("/showDetails")
	public PayrollModel getAllDetails() {
		List<PayrollModel> empDataList = null;
		empDataList = service.getAllDetails();
		return (PayrollModel) empDataList;
	}

//	Find data by ID
	@GetMapping("/find/{empId}")
	public PayrollModel getDetailsById(@PathVariable("empId") int empId) {
		PayrollModel empPayrollData = null;
		empPayrollData = service.detailsGetById(empId);
		return empPayrollData;
	}

//	Update Data
	@PutMapping("/update/{empId}")
	public PayrollModel updateDetails(@Valid @RequestBody PayrollDto payrollDto, @PathVariable int empId) {
		PayrollModel empData = null;
		empData = service.updatedetails(payrollDto, empId);
		return empData;

	}

//	delete details
	@DeleteMapping("/delete/{empId}")
	public String deleteDetails(@PathVariable("empId") int empId) {
		return service.deleteDetails(empId);
	}
}
