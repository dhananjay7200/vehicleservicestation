package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString

public class VehicleDTO {
	@JsonProperty("vid")
	private Integer vid;
	
	//@NotEmpty(message = "Vehical name must be supplied")
	//@Length(min = 4, max = 30, message = "Invalid Vehical name length")
	private String vname;


	//@NotBlank(message = "problem must be selected")
	private String problem;
	
	//@Range(min = 2, max = 10, message = "Invalid Mobile Number")
	private String reg_number;
	
	
	private LocalDate dateof_purchase;
}
