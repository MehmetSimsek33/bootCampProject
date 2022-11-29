package com.kodlama.io.bootCampProject.dataAccess.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.aplicants.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer> {

	BlackList findById(int id);
	BlackList findByApplicantId(int applicantId);
}
