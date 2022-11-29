package com.kodlama.io.bootCampProject.business.requests.users.applicants;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteApplicantRequest {
	@NotNull
	@NotBlank
	private int id;
}
