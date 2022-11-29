package com.kodlama.io.bootCampProject.business.abstracts.users;

import java.util.List;

import com.kodlama.io.bootCampProject.business.requests.users.Instructors.CreateInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.DeleteInstructorRequest;
import com.kodlama.io.bootCampProject.business.requests.users.Instructors.UpdateInstructorRequest;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.CreateInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.DeleteInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.GetAllInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.GetInstructorResponse;
import com.kodlama.io.bootCampProject.business.responses.users.Instructors.UpdateInstructorResponse;
import com.kodlama.io.bootCampProject.core.utilities.results.DataResult;
import com.kodlama.io.bootCampProject.core.utilities.results.Result;
import com.kodlama.io.bootCampProject.entities.users.Instructor;

public interface InstructorService {

	DataResult<CreateInstructorResponse> add(CreateInstructorRequest instructorRequest);

	DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest instructorRequest);

	Result delete(int id);

	DataResult<List<GetAllInstructorResponse>> getAll();

	DataResult<GetInstructorResponse> getById(int id);


}
