package com.bridgelabz.employeepayrollappspringboot.DTO;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class PayrollDto {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
	@NotEmpty(message = "Employee Name should not be Null")
	private String name;

	@NotBlank(message = "Profile Pic should not be Empty")
	private String profilePic;

	@Pattern(regexp = "male|female", message = "Gender Needs to be Male or Female")
	private String gender;

	@NotBlank(message = "Email Should not be empty")
	private String email;
	private List<String> department;

	@Min(value = 500, message = "Wage should be 500 or More")
	@Max(value = 999999, message = "Wage should not exceeds 999999")
	private long salary;

	@NotBlank(message = "Note Should not be empty")
	private String notes;

	// @Pattern(regexp = "dd-MM-yyyy")
	@NotNull(message = "Start Date Should not be Empty")
	private String startDate;

}
