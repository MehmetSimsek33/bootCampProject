package com.kodlama.io.bootCampProject.business.requests.users.Instructors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.requests.users.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateInstructorRequest extends UserRequest {
	
	@NotNull
	@NotBlank
	private int id;
	@NotNull
	@NotBlank
	private String companyName;
}
