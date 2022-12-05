package com.patientservice.repositoryTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.patientservice.model.Patient;
import com.patientservice.repository.PatientRepository;

@SpringBootTest
class PatientRepositoryTest {

	@Autowired
	private PatientRepository patientRepo;

	@Test
	void createPatientTest() {
		Patient patient = Patient.builder().patientName("Sam").DOB("09/07/22").emailId("sam@gmail.com")
				.phoneNumber("8798574897").drugId("51423-1542-21").drugName("Cora500").inductedStatus("INDUCTED")
				.build();
		patientRepo.save(patient);

		Patient retrievedPatient = patientRepo.findByPatientName("Sam");
		assertThat(retrievedPatient).isNotNull();
		assertThat(retrievedPatient.getPhoneNumber().equals(patient.getPhoneNumber()));
		
		//Clear data after test
		patientRepo.deleteById(retrievedPatient.getPatientId());
	}
	
	
	@Test
	void updatePatientTest() {
		Patient patient = Patient.builder().patientName("Sam").DOB("09/07/22").emailId("sam@gmail.com")
				.phoneNumber("8798574897").drugId("51423-1542-21").drugName("Cora500").inductedStatus("INDUCTED")
				.build();
		patientRepo.save(patient);
		patient.setDOB("01/07/22");
		patient.setPhoneNumber("7712457830");
		
		Patient retrievedPatient = patientRepo.findByPatientName("Sam");
		assertThat(retrievedPatient).isNotNull();
		assertThat(retrievedPatient.getPhoneNumber().equals("7712457830"));
		assertThat(retrievedPatient.getDOB().equals("01/07/22"));
		
		//Clear data after test
		patientRepo.deleteById(retrievedPatient.getPatientId());
	}
}
