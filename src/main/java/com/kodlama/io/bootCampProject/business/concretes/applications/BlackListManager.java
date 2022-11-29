package com.kodlama.io.bootCampProject.business.concretes.applications;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlama.io.bootCampProject.business.abstracts.applications.ApplicationsService;
import com.kodlama.io.bootCampProject.business.abstracts.applications.BlackListService;
import com.kodlama.io.bootCampProject.business.abstracts.users.ApplicantService;
import com.kodlama.io.bootCampProject.business.constant.Messages;
import com.kodlama.io.bootCampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlama.io.bootCampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlama.io.bootCampProject.business.responses.blackList.CreateBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.GetAllBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.UpdateBlackListResponse;
import com.kodlama.io.bootCampProject.core.utilities.exceptions.BusinessExcaption;
import com.kodlama.io.bootCampProject.core.utilities.mapping.ModelMapperService;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccesResult;
import com.kodlama.io.bootCampProject.core.utilities.results.SuccessDataResult;
import com.kodlama.io.bootCampProject.dataAccess.users.BlackListRepository;
import com.kodlama.io.bootCampProject.entities.aplicants.BlackList;
import com.kodlama.io.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {

	private ModelMapperService modelMapperService;
	private BlackListRepository blackListRepository;
	private ApplicantService applicantService;

	@Override
	public DataResult<CreateBlackListResponse> add(CreateBlackListRequest blackListRequest) {
		checkIfApplicantExistsById(blackListRequest.getApplicantId());
		checkIfBlackListExistByApplicantId(blackListRequest.getApplicantId());
		BlackList blackList = modelMapperService.forRequest().map(blackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		CreateBlackListResponse blackListResponse = modelMapperService.forResponse().map(blackList,
				CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(blackListResponse, Messages.BlackListCreated);
	}

	@Override
	public Result delete(int id) {
		checkIfBlackListExistsById(id);
		blackListRepository.deleteById(id);
		return new SuccesResult(Messages.BlackListDeleted);
	}

	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest blackListRequest) {
		checkIfBlackListExistsById(blackListRequest.getId());
		checkIfApplicantExistsById(blackListRequest.getApplicantId());
		checkIfUpdateBlackListExistsById(blackListRequest.getId(),blackListRequest.getApplicantId());
		BlackList blackList = modelMapperService.forRequest().map(blackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		UpdateBlackListResponse blackListResponse = modelMapperService.forResponse().map(blackList,
				UpdateBlackListResponse.class);

		return new SuccessDataResult<UpdateBlackListResponse>(blackListResponse, Messages.BlacklistUpdated);
	}

	@Override
	public DataResult<List<GetAllBlackListResponse>> getAll() {

		List<BlackList> blackLists = this.blackListRepository.findAll();
		List<GetAllBlackListResponse> applicationsResponses = blackLists.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllBlackListResponse.class))
				.collect(Collectors.toList());

		return new SuccessDataResult<List<GetAllBlackListResponse>>(applicationsResponses);
	}

	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListExistsById(id);
		BlackList blackList = this.blackListRepository.findById(id);
		GetBlackListResponse blackListResponse = this.modelMapperService.forResponse().map(blackList,
				GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(blackListResponse,Messages.BlacklistGet);
	}

	@Override
	public BlackList getByBlackListId(int id) {

		return checkIfBlackListExistsById(id);
	}

	private BlackList checkIfBlackListExistsById(int id) {
		BlackList blackList = this.blackListRepository.findById(id);
		if (blackList == null) {
			throw new BusinessExcaption(Messages.BlackListNoExists);
		}
		return blackList;
	}

	private void checkIfApplicantExistsById(int id) {
		Object applicant = this.applicantService.getById(id);
		if (applicant == null) {
			throw new BusinessExcaption(Messages.ApplicationDeleted);
		}
	

	}
	
	private BlackList checkIfBlackListExistByApplicantId(int id) {
		BlackList blackList = this.blackListRepository.findByApplicantId(id);
		if (blackList != null) {
			throw new BusinessExcaption(Messages.BlackListApplicantExists);
		}
		return blackList;

	}
	private void checkIfUpdateBlackListExistsById(int blackListId,int ApplicantId) {
		BlackList blackList = this.blackListRepository.findById(blackListId);
		if(blackList.getApplicant().getId()!=ApplicantId) {
			checkIfBlackListExistByApplicantId(ApplicantId);
		}
	}

	@Override
	public BlackList getBlackListByApplicantId(int id) {
		return checkIfBlackListExistByApplicantId(id);
	}

}
