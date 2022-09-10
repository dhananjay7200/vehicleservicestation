package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
@Table(name = "Vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer vId;
	@Column(length = 30)
	private String vname;
	@Column(length = 30)
	private String problem;
	@Column(length = 30)
	private LocalDate dateof_purchase;
	private Integer reg_number;
	@OneToMany//student-->*books
	@JoinColumn(name="u_id")
	private User uid;
	@OneToMany//student-->*books
	@JoinColumn(name="m_id")
	private Mechanic mid;
	
	
}
