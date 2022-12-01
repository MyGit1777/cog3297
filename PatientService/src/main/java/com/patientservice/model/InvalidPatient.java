package com.patientservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvalidPatient {

	public InvalidPatient(String patientName2, String validationMessage2) {
		this.patientName = patientName2;
		this.validationMessage = validationMessage2;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long patientId;
	private String patientName;
	private String validationMessage;
	private String status = "FAILED";

}
