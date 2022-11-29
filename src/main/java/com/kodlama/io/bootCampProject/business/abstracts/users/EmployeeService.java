package com.kodlama.io.bootCampProject.business.abstracts.users;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.users.employees.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.users.employees.DeleteEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.users.employees.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.DeleteEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.GetAllEmployeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface EmployeeService {

	DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest employeeRequest);

	DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest employeeRequest);

	Result  delete(int id);

	DataResult<List<GetAllEmployeResponse>> getAll();

	DataResult<GetEmployeeResponse> getById(int id);

}
