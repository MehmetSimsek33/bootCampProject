package com.kodlama.io.bootCampProject.business.concretes.users;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.DeleteApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.DeleteApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccesResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.dataAccess.users.ApplicantRepository;
import com.kodlama.io.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {

	private ModelMapperService modelMapperService;
	private ApplicantRepository applicantRepository;

	@Override
	public DataResult<CreateApplicantResponse> add(CreateApplicantRequest applicantRequest) {
		checkIfApplicantExistsByNationaltyIdentity(applicantRequest.getNationaltyIdentity());
		LocalDate date = parseLocalDate(applicantRequest.getDateOfBirth());
		Applicant applicant = this.modelMapperService.forRequest().map(applicantRequest, Applicant.class);
		applicant.setDateOfBirth(date);
		this.applicantRepository.save(applicant);
		CreateApplicantResponse applicantResponse = this.modelMapperService.forResponse().map(applicant,
				CreateApplicantResponse.class);
		return new SuccessDataResult<CreateApplicantResponse>(applicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest applicantRequest) {
		checkIfApplicantExistsById(applicantRequest.getId());
		Applicant applicant = this.modelMapperService.forRequest().map(applicantRequest, Applicant.class);
		this.applicantRepository.save(applicant);
		UpdateApplicantResponse applicantResponse = this.modelMapperService.forResponse().map(applicant,
				UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(applicantResponse, Messages.ApplicantUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfApplicantExistsById(id);
		this.applicantRepository.deleteById(id);
		return new SuccesResult(Messages.ApplicantDeleted);
	}

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		List<Applicant> applicants = this.applicantRepository.findAll();
		List<GetAllApplicantResponse> applicantResponses = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(applicantResponses, Messages.ApplicantGetAll);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		Applicant applicant = checkIfApplicantExistsById(id);
		GetApplicantResponse applicantResponse = this.modelMapperService.forResponse().map(applicant,
				GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(applicantResponse, Messages.ApplicantGet);
	}

	private Applicant checkIfApplicantExistsById(int id) {
		Applicant applicant = this.applicantRepository.findById(id);
		if (applicant == null) {
			throw new BusinessExcaption("Applicant not exist");

		}

		return applicant;

	}

	private void checkIfApplicantExistsByNationaltyIdentity(String nationaltyIdentity) {
		Applicant applicant = this.applicantRepository.findByNationaltyIdentity(nationaltyIdentity);
		if (applicant != null) {
			throw new BusinessExcaption("Applicant is exist");
		}

	}

	private LocalDate parseLocalDate(String date) {
		return LocalDate.parse(date);
	}


}
