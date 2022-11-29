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

import com.kodlama.io.bootCampProject.business.abstracts.users.InstructorService;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.DeleteInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.DeleteInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/instructors/")
@AllArgsConstructor
public class InstructorsController {

	private InstructorService instructorService;

	@PostMapping("add")
	public DataResult<CreateInstructorResponse> instructorResponse(
			@Valid @RequestBody CreateInstructorRequest instructorRequest) {
		return this.instructorService.add(instructorRequest);
	}

	@PutMapping("update")
	public DataResult<UpdateInstructorResponse> update(@Valid @RequestBody UpdateInstructorRequest instructorRequest) {
		return this.instructorService.update(instructorRequest);
	}

	@DeleteMapping("delete")
	public Result  delete(int id) {

		return this.instructorService.delete(id);
	}
	@GetMapping("getAll")
	public DataResult<List<GetAllInstructorResponse>> getAll()
	{
		return this.instructorService.getAll();
		
	}
	@GetMapping("getById/{id}")
	public DataResult<GetInstructorResponse> getById(@PathVariable int id)
	{
		return this.instructorService.getById(id);
		
	}

}
