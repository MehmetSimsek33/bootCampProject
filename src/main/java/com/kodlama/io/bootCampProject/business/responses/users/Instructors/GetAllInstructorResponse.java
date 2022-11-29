package com.kodlama.io.bootCampProject.business.responses.users.Instructors;

import com.kodlama.io.bootCampProject.business.responses.users.UserResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInstructorResponse extends UserResponse {

	private String possition;
}
