package com.kodlama.io.bootCampProject.business.requests.users.Instructors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.kodlama.io.bootCampProject.business.requests.users.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest extends UserRequest {
 
	@NotBlank
	@NotNull
	private String companyName;
}
