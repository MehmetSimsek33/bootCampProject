package com.kodlama.io.bootCampProject.business.requests.bootcamps;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBootcampRequest {

	@NotNull
	private String name;
	@NotNull
	@DateTimeFormat
	private String dateStart;
	@NotNull
	@DateTimeFormat
	private String dateEnd;
	private int state;
	@NotNull
	private int instructorId;

}
