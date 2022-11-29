package com.kodlama.io.bootCampProject.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.DeleteApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.DeleteApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/applicants/")
@RestController
@AllArgsConstructor
public class ApplicantController {
	private ApplicantService applicantService;

	@PostMapping("add")
	public DataResult<CreateApplicantResponse> add(@Valid @RequestBody CreateApplicantRequest applicantRequest) {
		return this.applicantService.add(applicantRequest);
	}

	@PutMapping("update")
	public DataResult<UpdateApplicantResponse> update(@Valid @RequestBody UpdateApplicantRequest applicantRequest) {

		return this.applicantService.update(applicantRequest);

	}

	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable @Valid int id) {
		return this.applicantService.delete(id); 
	}
	@GetMapping("getAll")
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		return this.applicantService.getAll();
	}
	@GetMapping("getById/{id}")
	public DataResult<GetApplicantResponse> getAll(@PathVariable int id) {
		return this.applicantService.getById(id);
	}
}
