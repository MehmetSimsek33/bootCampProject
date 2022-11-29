package com.kodlama.io.bootCampProject.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.bootCampProject.business.abstracts.users.EmployeeService;
import com.kodlama.io.bootCampProject.business.requests.users.employees.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.users.employees.DeleteEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.users.employees.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.DeleteEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.GetAllEmployeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@PostMapping("add")
	public  DataResult<CreateEmployeeResponse> add(@Valid @RequestBody CreateEmployeeRequest employeeRequest) {
		return this.employeeService.add(employeeRequest);
	}
	
	@PutMapping("update")
	public 	 DataResult<UpdateEmployeeResponse> update(@Valid @RequestBody UpdateEmployeeRequest employeeRequest) {
		return this.employeeService.update(employeeRequest);
	}
	
	@DeleteMapping("delete")
	public Result  delete(@Valid int id) {
		return this.employeeService.delete(id);
	}
	@GetMapping("getAll")
	public  DataResult<List<GetAllEmployeResponse>> getAll() {
		return this.employeeService.getAll();
	}
	
	
	
	

}
