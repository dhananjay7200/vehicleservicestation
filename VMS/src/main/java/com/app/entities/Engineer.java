package com.app.entities;

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
@Table(name = "Engineers")
public class Engineer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer eId;
	@Column(length = 30)
	private String name;
}
