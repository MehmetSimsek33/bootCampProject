package com.kodlama.io.bootCampProject.business.concretes.users;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.users.InstructorService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.DeleteInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.DeleteInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccesResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.dataAccess.users.InstructorRepository;
import com.kodlama.io.bootCampProject.entities.users.Employee;
import com.kodlama.io.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {

	private InstructorRepository instructorRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreateInstructorResponse> add(CreateInstructorRequest instructorRequest) {
		checkIfInstructorExistsByNationaltyIdentity(instructorRequest.getNationaltyIdentity());
		LocalDate date = parseLocalDate(instructorRequest.getDateOfBirth());
		Instructor instructor = this.modelMapperService.forRequest().map(instructorRequest, Instructor.class);
		instructor.setDateOfBirth(date);
		instructorRepository.save(instructor);
		CreateInstructorResponse instructorResponse = this.modelMapperService.forResponse().map(instructor,
				CreateInstructorResponse.class);
		return new SuccessDataResult<CreateInstructorResponse>(instructorResponse, Messages.InstructorCreated);

	}

	@Override
	public Result  delete(int id) {
		checkIfInstructorExistsById(id);
		this.instructorRepository.deleteById(id);
		return new SuccesResult(Messages.InructorDeleted);
	}

	@Override
	public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest instructorRequest) {
		Instructor instructor = this.modelMapperService.forRequest().map(instructorRequest, Instructor.class);
		instructorRepository.save(instructor);
		UpdateInstructorResponse instructorResponse = this.modelMapperService.forResponse().map(instructor,
				UpdateInstructorResponse.class);
		return new SuccessDataResult<UpdateInstructorResponse>(instructorResponse);
	}

	@Override
	public DataResult<List<GetAllInstructorResponse>> getAll() {

		List<Instructor> instructors = this.instructorRepository.findAll();
		List<GetAllInstructorResponse> instructorResponses = instructors.stream().map(
				instructor -> this.modelMapperService.forResponse().map(instructor, GetAllInstructorResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllInstructorResponse>>(instructorResponses);
	}

	@Override
	public DataResult<GetInstructorResponse> getById(int id) {
		Instructor instructor = checkIfInstructorExistsById(id);
		GetInstructorResponse instructorResponse = this.modelMapperService.forResponse().map(instructor,
				GetInstructorResponse.class);
		return new SuccessDataResult<GetInstructorResponse>(instructorResponse);
	}

	private Instructor checkIfInstructorExistsById(int id) {
		Instructor instructor = this.instructorRepository.findById(id);
		if (instructor == null) {
			throw new BusinessExcaption("Instructor not exist");
		}
		return instructor;

	}

	private void checkIfInstructorExistsByNationaltyIdentity(String nationaltyIdentity) {
		Instructor instructor = this.instructorRepository.findByNationaltyIdentity(nationaltyIdentity);
		if (instructor != null) {
			throw new BusinessExcaption("Instructor not exist");
		}

	}


	private LocalDate parseLocalDate(String date) {
		return LocalDate.parse(date);
	}

}
