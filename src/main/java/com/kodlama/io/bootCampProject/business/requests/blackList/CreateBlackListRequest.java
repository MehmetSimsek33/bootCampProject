package com.kodlama.io.bootCampProject.business.requests.blackList;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBlackListRequest {
	
	//@UpdateTimestamp
	@CreatedDate
	private LocalDate date;
	@NotNull
	@NotBlank
	@NotEmpty
	private String reason;
	@Min(0)
	private int applicantId;
}
