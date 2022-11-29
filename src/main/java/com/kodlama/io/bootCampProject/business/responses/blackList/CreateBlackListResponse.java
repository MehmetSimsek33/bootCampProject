package com.kodlama.io.bootCampProject.business.responses.blackList;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateBlackListResponse {
	private int id;
	private LocalDate date;
	private String reason;
	private int applicantId;
}
