package com.kodlama.io.bootCampProject.dataAccess.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer> {

	Bootcamp findById(int id);

	Bootcamp findByName(String name);

}
