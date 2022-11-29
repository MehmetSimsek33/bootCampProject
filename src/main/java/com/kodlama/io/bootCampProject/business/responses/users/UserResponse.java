package com.kodlama.io.bootCampProject.business.responses.users;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private LocalDate dateOfBirth;
	private String nationaltyIdentity;
}
