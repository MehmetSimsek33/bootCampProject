package com.kodlama.io.bootCampProject.business.responses.users.Employees;

import com.kodlama.io.bootCampProject.business.responses.users.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeResponse  extends UserResponse{

	private String possition;

}
 