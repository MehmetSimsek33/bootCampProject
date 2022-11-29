package com.kodlama.io.bootCampProject.business.requests.users;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {
	@NotNull
	@NotBlank
	@NotEmpty
	@DateTimeFormat
	private String dateOfBirth;
	@NotNull
	@NotBlank
	@NotEmpty
	@Size(min = 11, max = 11)
	private String nationaltyIdentity;
	@NotNull
	@NotBlank
	@NotEmpty
	private String firstName;
	@NotNull
	@NotBlank
	@NotEmpty
	private String lastName;
	@NotNull
	@NotBlank
	@NotEmpty
	@Email()
	private String email;
	@NotNull
	@NotBlank
	@NotEmpty
	private String password;
}
