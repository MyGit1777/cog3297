package com.patientservice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.patientservice.model.Patient;

public interface PatientService {
	public void savePatientData(MultipartFile file);

	public List<Patient> getAllPatients();
	public Patient getPatientByName(String patientName);
	public void updatePatient(Patient patient);
}
