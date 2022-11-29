package com.kodlama.io.bootCampProject.entities.users;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.entities.Bootcamp;
import com.kodlama.io.bootCampProject.entities.aplicants.Application;
import com.kodlama.io.bootCampProject.entities.aplicants.BlackList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "applicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {
	@Column(name = "about")
	private String about;

	@OneToMany(mappedBy = "applicant",cascade = CascadeType.ALL)
	private List<BlackList> blackLists;

	@OneToMany(mappedBy = "applicant",cascade = CascadeType.ALL)
	private List<Application> applications;

}
