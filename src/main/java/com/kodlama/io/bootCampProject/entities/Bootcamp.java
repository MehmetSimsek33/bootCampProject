package com.kodlama.io.bootCampProject.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kodlama.io.bootCampProject.entities.users.Instructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "bootcamps")
public class Bootcamp {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_start")
	private LocalDate dateStart;
	@Column(name = "date_end")
	private LocalDate dateEnd;

	@Column(name="state")
	private int state;

	@ManyToOne
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
} 
