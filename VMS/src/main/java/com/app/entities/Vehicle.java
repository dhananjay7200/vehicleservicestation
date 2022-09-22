package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	private Integer vid;
	@Column(length = 30)
	private String vname;
	@Column(length = 30)
	private String problem;
	private LocalDate dateof_purchase;
	@Column(length = 30)
	private String reg_number;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="u_id")
	private User uid;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="m_id")
	private Mechanic mid;
	
	
}
