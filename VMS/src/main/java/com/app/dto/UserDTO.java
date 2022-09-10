package com.app.dto;


import javax.validation.constraints.Email;

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

public class UserDTO {
	@JsonProperty("uid")
	private Integer uid;
	
	@NotEmpty(message = "First name must be supplied")
	@Length(min = 4, max = 30, message = "Invalid First name length")
	private String name;

	@NotBlank
	@Email(message = "Invalid Email")
	private String email;

	@NotBlank(message = "address is required")
	private String address;
	
	@Range(min = 10, max = 10, message = "Invalid Mobile Number")
	private Integer mob_number;

}
