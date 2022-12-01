package com.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patientservice.model.InvalidPatient;
import com.patientservice.model.Patient;

public interface InvalidPatientRepository extends JpaRepository<InvalidPatient, Long> {
	Patient findByPatientName(String patientName);
}
