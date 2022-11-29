package com.kodlama.io.bootCampProject.business.responses.users.Applicants;

import com.kodlama.io.bootCampProject.business.responses.users.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetApplicantResponse extends UserResponse {

	private String about;

}
