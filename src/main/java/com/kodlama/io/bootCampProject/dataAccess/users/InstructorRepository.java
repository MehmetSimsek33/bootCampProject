package com.kodlama.io.bootCampProject.dataAccess.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlama.io.bootCampProject.entities.users.Employee;
import com.kodlama.io.bootCampProject.entities.users.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

	Instructor findById(int id);
	Instructor findByNationaltyIdentity(String nationaltyId);
}
