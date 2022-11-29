package com.kodlama.io.bootCampProject.business.requests.users.employees;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.requests.users.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateEmployeeRequest extends UserRequest {
 

	@NotNull
	@NotBlank
	private String possition;
}
