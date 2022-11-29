package com.kodlama.io.bootCampProject.business.abstracts.applications;

import java.util.List;

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
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;

public interface ApplicationsService {

	DataResult<CreateApplicationsResponse> add(CreateAplicationRequest applicationRequest);

	DataResult<UpdateApplicationsResponse> update(UpdateAplicationRequest applicationRequest);

	Result delete(int id);

	DataResult<GetApplicationsResponse> getById(int id);

	DataResult<List<GetAllApplicationsResponse>> getAll();
}
