package com.kodlama.io.bootCampProject.business.responses.applications;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllApplicationsResponse {
	private int id;

	private int state;

	private int applicantId;

	private int bootCampId;
}
