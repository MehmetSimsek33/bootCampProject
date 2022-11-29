package com.kodlama.io.bootCampProject.business.concretes.applications;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.applications.ApplicationsService;
import com.kodlama.io.bootCampProject.business.abstracts.applications.BlackListService;
import com.kodlama.io.bootCampProject.business.abstracts.bootcamps.BootcampService;
import com.kodlama.io.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.applications.CreateAplicationRequest;
import com.kodlama.io.bootCampProject.business.requests.applications.UpdateAplicationRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.applications.CreateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetAllApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.GetApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.applications.UpdateApplicationsResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccesResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.dataAccess.users.ApplicationtRepository;
import com.kodlama.io.bootCampProject.entities.Bootcamp;
import com.kodlama.io.bootCampProject.entities.aplicants.Application;
import com.kodlama.io.bootCampProject.entities.aplicants.BlackList;
import com.kodlama.io.bootCampProject.entities.users.Applicant;
import com.kodlama.io.bootCampProject.entities.users.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicationsManager implements ApplicationsService {
	private ModelMapperService modelMapperService;
	private ApplicationtRepository applicationtRepository;
	private BootcampService bootcampService;
	private ApplicantService applicantService;
	private BlackListService blackListService;

	@Override
	public DataResult<CreateApplicationsResponse> add(CreateAplicationRequest applicationRequest) {
		checkIfBootcampExistsByNationaltyIdentity(applicationRequest.getBootCampId());
		checkIfApplicantExistsById(applicationRequest.getApplicantId());
		checkIfBlackListExistsById(applicationRequest.getApplicantId());
		Application application = this.modelMapperService.forRequest().map(applicationRequest, Application.class);
		this.applicationtRepository.save(application);
		CreateApplicationsResponse applicationsResponse = this.modelMapperService.forResponse().map(application,
				CreateApplicationsResponse.class);
		return new SuccessDataResult<CreateApplicationsResponse>(applicationsResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<UpdateApplicationsResponse> update(UpdateAplicationRequest applicationRequest) {
		checkIfBootcampExistsByNationaltyIdentity(applicationRequest.getBootCampId());
		checkIfBlackListExistsById(applicationRequest.getApplicantId());
		checkIfApplicationExistsById(applicationRequest.getId());
		Application application = this.modelMapperService.forRequest().map(applicationRequest, Application.class);
		this.applicationtRepository.save(application);
		UpdateApplicationsResponse applicationsResponse = this.modelMapperService.forResponse().map(application,
				UpdateApplicationsResponse.class);
		return new SuccessDataResult<UpdateApplicationsResponse>(applicationsResponse, Messages.ApplicationUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfApplicationExistsById(id);
		this.applicationtRepository.deleteById(id);
		return new SuccesResult("Silindi");
	}

	@Override
	public DataResult<GetApplicationsResponse> getById(int id) {
		checkIfApplicationExistsById(id);
		Application application = this.applicationtRepository.findById(id);
		GetApplicationsResponse applicationsResponse = this.modelMapperService.forResponse().map(application,
				GetApplicationsResponse.class);
		return new SuccessDataResult<GetApplicationsResponse>(applicationsResponse, Messages.ApplicationGet);
	}

	@Override
	public DataResult<List<GetAllApplicationsResponse>> getAll() {
		List<Application> applications = this.applicationtRepository.findAll();
		List<GetAllApplicationsResponse> applicationsResponses = applications.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllApplicationsResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllApplicationsResponse>>(applicationsResponses,
				Messages.ApplicationGetAll);
	}

	private Application checkIfApplicationExistsById(int id) {
		Application application = this.applicationtRepository.findById(id);
		if (application == null) {
			throw new BusinessExcaption(Messages.ApplicationExists);
		}
		return application;

	}

	private void checkIfBootcampExistsByNationaltyIdentity(int id) {
		Object bootcamp = this.bootcampService.getById(id);
		if (bootcamp == null) {
			throw new BusinessExcaption(Messages.BootcampExists);
		}
	}

	private void checkIfApplicantExistsById(int id) {
		Object applicant = this.applicantService.getById(id);
		if (applicant == null) {
			throw new BusinessExcaption(Messages.ApplicantExists);
		}

	}
	

	private BlackList checkIfBlackListExistsById(int id) {
		BlackList blackList = this.blackListService.getBlackListByApplicantId(id);
		if (blackList != null) {
			throw new BusinessExcaption(Messages.BlackListExists);
		}
		return blackList;

	}
	private void checkIfBootcampState(int id) {
		Integer applicant = this.bootcampService.getBootcampState(id);
		if (applicant == 2) {
			throw new BusinessExcaption(Messages.BootcampClosed);
		}

	}
	
}
