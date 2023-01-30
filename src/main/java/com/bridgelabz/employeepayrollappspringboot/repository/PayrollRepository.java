package com.bridgelabz.employeepayrollappspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollappspringboot.model.PayrollModel;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollModel, Integer> {
	@Query(value = "select * from employee_payroll_data, employee_department where employee_id = id and department = :department", nativeQuery = true)
	List<PayrollModel> findEmployeesByDepartment(String department);
}
