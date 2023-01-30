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
	public ResponseEntity<ResponseDTO> addDetails(@Valid @RequestBody PayrollDto payrollDto) {
		PayrollModel empData = null;
		empData = service.addEmployeeDetails(payrollDto);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

//	show all data
	@GetMapping("/showDetails")
	public ResponseEntity<ResponseDTO> getAllDetails() {
		List<PayrollModel> empDataList = null;
		empDataList = service.getAllDetails();
		ResponseDTO respDTO = new ResponseDTO("Get Call Success", empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

//	Find data by ID
	@GetMapping("/find/{empId}")
	public ResponseEntity<ResponseDTO> getDetailsById(@PathVariable("empId") int empId) {
		PayrollModel empPayrollData = null;
		empPayrollData = service.detailsGetById(empId);
		ResponseDTO respDTO = new ResponseDTO("Get Call for Id Successfull", empPayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

//	Update Data
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateDetails(@Valid @RequestBody PayrollDto payrollDto,
			@PathVariable int empId) {
		PayrollModel empData = null;
		empData = service.updatedetails(payrollDto, empId);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee payroll Data for: ", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

//	delete details
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteDetails(@PathVariable("empId") int empId) {
		service.deleteDetails(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " + empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
