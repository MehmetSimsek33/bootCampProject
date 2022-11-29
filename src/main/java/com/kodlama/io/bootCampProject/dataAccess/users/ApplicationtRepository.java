package com.kodlama.io.bootCampProject.dataAccess.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlama.io.bootCampProject.entities.aplicants.Application;

public interface ApplicationtRepository extends JpaRepository<Application, Integer> {
	Application findById(int id);


}
