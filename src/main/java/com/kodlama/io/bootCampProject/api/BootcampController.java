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

import com.kodlama.io.bootCampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/bootcamps/")
public class BootcampController {

	private BootcampService bootcampService;
	
	@PostMapping("add")
	public DataResult<CreateBootcampResponse> add(@Valid @RequestBody CreateBootcampRequest bootcampRequest){
		return this.bootcampService.add(bootcampRequest);
	}
	@PutMapping("update")
	public DataResult<UpdateBootcampResponse> update(@Valid @RequestBody UpdateBootcampRequest bootcampRequest) {
		return this.bootcampService.update(bootcampRequest);
	}
	@GetMapping("getAll")
	public DataResult<List<GetAllBootcampResponse>> getAll(){
		return this.bootcampService.getAll();
	}
	@DeleteMapping("delete/{id}")
	public Result delete(@PathVariable int id) {
		return this.bootcampService.delete(id);
	}
	@GetMapping("getById/{id}")
	public DataResult<GetBootcampResponse> getById(@PathVariable int id) {
		return this.bootcampService.getById(id);
	}
}
