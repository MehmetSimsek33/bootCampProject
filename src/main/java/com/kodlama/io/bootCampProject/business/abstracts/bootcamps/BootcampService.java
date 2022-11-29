package com.kodlama.io.bootCampProject.business.abstracts.bootcamps;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.bootcamps.CreateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.bootcamps.UpdateBootcampRequest;
import com.kodlama.io.bootCampProject.business.requests.users.applicants.UpdateApplicantRequest;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.CreateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetAllBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.GetBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.bootcamps.UpdateBootcampResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.GetAllApplicantResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Applicants.UpdateApplicantResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.entities.Bootcamp;

public interface BootcampService {

	DataResult<CreateBootcampResponse> add(CreateBootcampRequest bootcampRequest);

	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest bootcampRequest);

	Result delete(int id);

	DataResult<GetBootcampResponse> getById(int id);

	DataResult<List<GetAllBootcampResponse>> getAll();

	Integer getBootcampState(int id);

}
