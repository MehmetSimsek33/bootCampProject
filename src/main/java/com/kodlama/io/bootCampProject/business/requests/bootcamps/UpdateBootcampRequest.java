package com.kodlama.io.bootCampProject.business.requests.bootcamps;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateBootcampRequest {
	@NotEmpty
	@NotNull
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	@DateTimeFormat
	private String dateStart;
	@NotNull
	@DateTimeFormat
	private String dateEnd;
	@NotEmpty
	@NotNull
	private int instructorId;
	private int state;
}
