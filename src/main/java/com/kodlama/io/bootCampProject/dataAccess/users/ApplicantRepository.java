package com.kodlama.io.bootCampProject.dataAccess.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlama.io.bootCampProject.entities.users.Applicant;
@Repository
public interface ApplicantRepository extends JpaRepository<Applicant,Integer> {

	Applicant findById(int id);
	Applicant findByNationaltyIdentity(String nationaltyId);
}
 