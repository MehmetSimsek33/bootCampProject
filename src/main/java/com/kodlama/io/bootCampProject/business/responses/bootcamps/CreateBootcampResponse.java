package com.kodlama.io.bootCampProject.business.responses.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampResponse {
	private int id;
	private String name;
	private String dateStart;
	private String dateEnd;
	private int state;
	private int instructorId;
}
