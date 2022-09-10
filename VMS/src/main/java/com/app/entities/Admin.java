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
@Table(name = "Admins")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer aId;
	@Column(length = 30)
	private String name;

}
