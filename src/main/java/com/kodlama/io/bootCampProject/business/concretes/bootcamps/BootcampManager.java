package com.kodlama.io.bootCampProject.business.concretes.bootcamps;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlama.io.bootCampProject.business.abstracts.users.InstructorService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccesResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.dataAccess.users.BootcampRepository;
import com.kodlama.io.bootCampProject.entities.Bootcamp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BootcampManager implements BootcampService {
	private BootcampRepository bootcampRepository;
	private ModelMapperService modelMapperService;
	private InstructorService instructorService;

	@Override
	public DataResult<CreateBootcampResponse> add(CreateBootcampRequest bootcampRequest) {
		LocalDate startDate = parseDate(bootcampRequest.getDateStart());
		LocalDate endDate = parseDate(bootcampRequest.getDateEnd());
		checkIfInstructorExistsById(bootcampRequest.getInstructorId());
		Bootcamp bootcamp = this.modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);
		checkIfStartDateIsItBıgEndDate(startDate, endDate);
		bootcamp.setDateStart(startDate);
		bootcamp.setDateEnd(endDate);
		this.bootcampRepository.save(bootcamp);
		CreateBootcampResponse bootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				CreateBootcampResponse.class);
		return new SuccessDataResult<CreateBootcampResponse>(bootcampResponse, Messages.BootcampCreated);
	}

	@Override
	public DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest bootcampRequest) {
		checkIfBootcampExistsById(bootcampRequest.getId());
		checkIfInstructorExistsById(bootcampRequest.getInstructorId());
		Bootcamp bootcamp = this.modelMapperService.forRequest().map(bootcampRequest, Bootcamp.class);
		UpdateBootcampResponse bootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				UpdateBootcampResponse.class);
		return new SuccessDataResult<UpdateBootcampResponse>(bootcampResponse, Messages.BootcampUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfBootcampExistsById(id);
		this.bootcampRepository.deleteById(id);
		return new SuccesResult(Messages.BootcampDeleted);
	}

	@Override
	public DataResult<GetBootcampResponse> getById(int id) {
		Bootcamp bootcamp = checkIfBootcampExistsById(id);
		GetBootcampResponse bootcampResponse = this.modelMapperService.forResponse().map(bootcamp,
				GetBootcampResponse.class);
		// TODO Auto-generated method stub
		return new SuccessDataResult<GetBootcampResponse>(bootcampResponse);
	}

	@Override
	public DataResult<List<GetAllBootcampResponse>> getAll() {
		List<Bootcamp> bootcamps = this.bootcampRepository.findAll();
		List<GetAllBootcampResponse> bootcampResponses = bootcamps.stream()
				.map(bootcamp -> this.modelMapperService.forResponse().map(bootcamp, GetAllBootcampResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBootcampResponse>>(bootcampResponses, Messages.BootcampGetAll);
	}

	private Bootcamp checkIfBootcampExistsById(int id) {
		Bootcamp bootcamp = this.bootcampRepository.findById(id);
		if (bootcamp == null) {
			throw new BusinessExcaption(Messages.BootcampExists);
		}
		return bootcamp;
	}

	private void checkIfInstructorExistsById(int id) {
		Object instructor = this.instructorService.getById(id);
		if (instructor == null) {
			throw new BusinessExcaption(Messages.InstructorExists);
		}

	}

	private LocalDate parseDate(String date) {
		return LocalDate.parse(date);
	}

	private void checkIfStartDateIsItBıgEndDate(LocalDate startDate, LocalDate enDate) {
		if (startDate.isAfter(enDate)) {
			throw new BusinessExcaption(Messages.StartDateIsItBıgEndDate);
		}
	}

	public Integer getBootcampState(int id) {
	Bootcamp bootcamp=this.bootcampRepository.findById(id);
		return bootcamp.getState();
	}
//	@Override
//	public Bootcamp getBootcampById(int id) {
//		return checkIfBootcampExistsById(id);
//	}

}
