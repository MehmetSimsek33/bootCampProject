package com.kodlama.io.bootCampProject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateApplicationsResponse {
	private int id;

	private int state;

	private int applicantId;

	private int bootCampId;
}
