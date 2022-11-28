package com.patientservice.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.patientservice.helper.ExcelToDBHelper;
import com.patientservice.model.Patient;
import com.patientservice.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Override
	public void savePatientData(MultipartFile file) {

		try {
			List<Patient> products = ExcelToDBHelper.extractListOfPatients(file.getInputStream());
			this.patientRepo.saveAll(products);
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
}
