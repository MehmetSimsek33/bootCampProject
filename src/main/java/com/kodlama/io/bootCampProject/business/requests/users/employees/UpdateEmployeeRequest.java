package com.kodlama.io.bootCampProject.business.requests.users.employees;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.requests.users.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest extends UserRequest {

	@NotNull
	private int id;
	private String possition;
}
