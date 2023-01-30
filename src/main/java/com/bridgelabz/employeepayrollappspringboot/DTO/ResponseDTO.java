package com.bridgelabz.employeepayrollappspringboot.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Used to send response back to the browser, holds the message and response object
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
	private String message;
	private Object data;
}
