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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "instructors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Instructor extends User {
	@Column(name = "company_name")
	private String companyName;

	@OneToMany(mappedBy = "instructor",cascade = CascadeType.ALL)
	private List<Bootcamp> bootcamps;

}
