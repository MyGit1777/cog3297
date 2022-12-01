package com.dataloaderportal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

	private long patientId;
	private String patientName;
	private String address;
	private String DOB;
	private String emailId;
	private String phoneNumber;
	private String drugId;
	private String drugName;

	public Patient(Patient patient) {
	}
}
