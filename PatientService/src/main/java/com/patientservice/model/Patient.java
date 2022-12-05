package com.patientservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long patientId;
	private String patientName;
	private String address;
	private String DOB;
	private String emailId;
	private String phoneNumber;
	private String drugId;
	private String drugName;
	private String inductedStatus;
	
	@Transient
	private boolean isDataValid = true;
	@Transient
	private StringBuffer validationMessage;
}
