package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Vehicles_history")
public class Vehicle_History {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer srno;
	@Column(length = 30)
	private String problem;
	@Column(length = 30)
	private LocalDate dateof_arrivel;
	private LocalDate dateof_dispatch;
}