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

import com.kodlama.io.bootCampProject.business.abstracts.applications.ApplicationsService;
import com.kodlama.io.bootCampProject.business.requests.applications.CreateAplicationRequest;
import com.kodlama.io.bootCampProject.business.requests.applications.UpdateAplicationRequest;
import com.kodlama.io.bootCampProject.business.responses.applications.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.UpdateApplicationsResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RequestMapping("/api/applications/")
@RestController
@AllArgsConstructor
public class ApplicationController {
	private ApplicationsService applicationsService;

	@PostMapping("add")
	public DataResult<CreateApplicationsResponse> add(@Valid @RequestBody CreateAplicationRequest applicationRequest) {
		return this.applicationsService.add(applicationRequest);
	}

	@PutMapping("update")
	public DataResult<UpdateApplicationsResponse> update(@Valid @RequestBody UpdateAplicationRequest applicationRequest) {
		return this.applicationsService.update(applicationRequest);

	}

	@DeleteMapping("delete/{id}")
	public Result delete(@Valid @PathVariable int id) {
		return this.applicationsService.delete(id);
	}

	@GetMapping("getById/{id}")
	public DataResult<GetApplicationsResponse> getById(@PathVariable int id) {
		return this.applicationsService.getById(id);
	}

	@GetMapping("getAll")
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		return this.applicationsService.getAll();
	}

}
