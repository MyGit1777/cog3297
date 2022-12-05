package com.patientservice.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.patientservice.helper.ExcelToDBHelper;
import com.patientservice.model.InvalidPatient;
import com.patientservice.model.Patient;
import com.patientservice.repository.InvalidPatientRepository;
import com.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private InvalidPatientRepository invalidPatientRepo;
	
	public PatientServiceImpl(PatientRepository patientRepo2) {
			this.patientRepo = patientRepo2;
			
	}

	@Override
	public void savePatientData(MultipartFile file) {

		try {
			List<Patient> patients = ExcelToDBHelper.extractListOfPatients(file.getInputStream());
			//Save valid patient details
			
			List<Patient> validPatients = patients.stream().filter(patient-> patient.isDataValid() == true).collect(Collectors.toList());
			this.patientRepo.saveAll(validPatients);
			
			//Save invalid patients
			saveInvalidPatientData(patients);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Patient> getAllPatients() {

		return this.patientRepo.findAll();
	}

	@Override
	public Patient getPatientByName(String patientName) {

		return patientRepo.findByPatientName(patientName);
	}

	@Override
	public void updatePatient(Patient patient) {
		patientRepo.save(patient);
	}

	public void saveInvalidPatientData(List<Patient> allPatients) {
		List<InvalidPatient> invalidPatients = new ArrayList<>();
		
		allPatients.stream().
		filter(patient-> patient.isDataValid() == false)
		.forEach(patient-> invalidPatients.add(new InvalidPatient(patient.getPatientName(), patient.getValidationMessage().toString()) ) );
		invalidPatientRepo.saveAll(invalidPatients);
	}
}
