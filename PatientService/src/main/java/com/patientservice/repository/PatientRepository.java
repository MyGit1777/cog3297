package com.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientservice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	Patient findByPatientName(String patientName);
}
