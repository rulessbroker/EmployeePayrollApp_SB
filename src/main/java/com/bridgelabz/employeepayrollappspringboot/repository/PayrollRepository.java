package com.bridgelabz.employeepayrollappspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.employeepayrollappspringboot.model.PayrollModel;

@Repository
public interface PayrollRepository extends JpaRepository<PayrollModel, Integer> {

}
