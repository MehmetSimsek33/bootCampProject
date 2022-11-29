package com.kodlama.io.bootCampProject.business.abstracts.users;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.users.applicants.CreateApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.DeleteApplicantRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.CreateApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.DeleteApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.entities.users.Applicant;

public interface ApplicantService {

	DataResult<CreateApplicantResponse> add(CreateApplicantRequest applicantRequest);

	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest applicantRequest);

	Result  delete(int id);

	DataResult<List<GetAllApplicantResponse>> getAll();

	DataResult<GetApplicantResponse> getById(int id);


}
