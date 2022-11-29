package com.kodlama.io.bootCampProject.business.concretes.users;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.kodlama.io.bootCampProject.business.abstracts.users.EmployeeService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.users.employees.CreateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.users.employees.DeleteEmployeeRequest;
import com.kodlama.io.bootCampProject.business.requests.users.employees.UpdateEmployeeRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.CreateEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.DeleteEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.GetAllEmployeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.GetEmployeeResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Employees.UpdateEmployeeResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccesResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.dataAccess.users.EmployeeRepository;
import com.kodlama.io.bootCampProject.entities.users.Applicant;
import com.kodlama.io.bootCampProject.entities.users.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateEmployeeResponse> add(CreateEmployeeRequest employeeRequest) {
		checkIfEmployeeExistsByNationaltyIdentity(employeeRequest.getNationaltyIdentity());
		LocalDate date = parseLocalDate(employeeRequest.getDateOfBirth());
		Employee employee = this.modelMapperService.forRequest().map(employeeRequest, Employee.class);
		this.employeeRepository.save(employee);
		CreateEmployeeResponse employeResponse = this.modelMapperService.forResponse().map(employee,
				CreateEmployeeResponse.class);

		return new SuccessDataResult<CreateEmployeeResponse>(employeResponse,Messages.EmployeeCreated);
	}

	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest employeeRequest) {
		checkIfEmployeeExistsById(employeeRequest.getId());
		LocalDate date = parseLocalDate(employeeRequest.getDateOfBirth());
		Employee employee = this.modelMapperService.forRequest().map(employeeRequest, Employee.class);
		employee.setDateOfBirth(date);
		this.employeeRepository.save(employee);
		UpdateEmployeeResponse employeResponse = this.modelMapperService.forResponse().map(employee,
				UpdateEmployeeResponse.class);

		return new SuccessDataResult<UpdateEmployeeResponse>(employeResponse,Messages.EmployeeUpdated);
	}

	@Override
	public Result  delete(int id) {
		checkIfEmployeeExistsById(id);
		this.employeeRepository.deleteById(id);
		return new SuccesResult(Messages.EmployeeDeleted);

	}

	@Override
	public DataResult<List<GetAllEmployeResponse>> getAll() {
		List<Employee> employees = this.employeeRepository.findAll();

		List<GetAllEmployeResponse> employeResponses = employees.stream()
				.map(response -> this.modelMapperService.forResponse().map(response, GetAllEmployeResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllEmployeResponse>>(employeResponses,Messages.EmployeeGetAll);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee = checkIfEmployeeExistsById(id);
		GetEmployeeResponse employeeResponse = this.modelMapperService.forResponse().map(employee,
				GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(employeeResponse,Messages.EmployeeGet);
	}

	private Employee checkIfEmployeeExistsById(int id) {
		Employee employee = this.employeeRepository.findById(id);
		if (employee != null) {
			return employee;
		}
		throw new BusinessExcaption("Employee not exist");
	}

	private void checkIfEmployeeExistsByNationaltyIdentity(String nationaltyIdentity) {
		Employee employee = this.employeeRepository.findByNationaltyIdentity(nationaltyIdentity);
		if (employee != null) {
			throw new BusinessExcaption("Employe nationalty is exist");
		}

	}
	private LocalDate parseLocalDate(String date) {
		return LocalDate.parse(date);
	}
}
