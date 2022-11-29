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

import com.kodlama.io.bootCampProject.business.abstracts.applications.BlackListService;
import com.kodlama.io.bootCampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlama.io.bootCampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlama.io.bootCampProject.business.responses.blackList.CreateBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.GetAllBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.UpdateBlackListResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/blacklists/")
public class BlackListController {
	private BlackListService blackListService;

	@GetMapping("getAll")
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		return this.blackListService.getAll();
	}

	@PostMapping("add")
	public DataResult<CreateBlackListResponse> add(@Valid @RequestBody CreateBlackListRequest blackListRequest) {
		System.out.println(blackListRequest.getApplicantId());
		return this.blackListService.add(blackListRequest);
	}

	@DeleteMapping("delete/{id}")
	public Result delete(int id) {
		return this.blackListService.delete(id);
	}

	@PutMapping("update")
	public DataResult<UpdateBlackListResponse> update(@Valid @RequestBody UpdateBlackListRequest blackListRequest) {

		return this.blackListService.update(blackListRequest);
	}

	@GetMapping("getById/{id}")
	public DataResult<GetBlackListResponse> getById(@PathVariable int id) {
		return this.blackListService.getById(id);
	}
}
