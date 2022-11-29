package com.kodlama.io.bootCampProject.business.requests.applications;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateAplicationRequest {


	
	private int state;

	@NotNull
	private int applicantId;
	@NotNull
	private int bootCampId;
}
