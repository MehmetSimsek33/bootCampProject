package com.kodlama.io.bootCampProject.business.abstracts.applications;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.blackList.CreateBlackListRequest;
import com.kodlama.io.bootCampProject.business.requests.blackList.UpdateBlackListRequest;
import com.kodlama.io.bootCampProject.business.responses.blackList.CreateBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.GetAllBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.GetBlackListResponse;
import com.kodlama.io.bootCampProject.business.responses.blackList.UpdateBlackListResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.entities.aplicants.BlackList;

public interface BlackListService {
	DataResult<List<GetAllBlackListResponse>> getAll();

	DataResult<GetBlackListResponse> getById(int id);

	DataResult<CreateBlackListResponse> add(CreateBlackListRequest blackListRequest);

	Result delete(int id);

	DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest blackListRequest);

	BlackList  getByBlackListId(int id);

	BlackList getBlackListByApplicantId(int id);

}
