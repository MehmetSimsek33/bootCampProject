package com.kodlama.io.bootCampProject.business.requests.users.applicants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.kodlama.io.bootCampProject.business.requests.users.UserRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateApplicantRequest extends UserRequest{
	@NotNull
	private int id;
	private String about;
}
