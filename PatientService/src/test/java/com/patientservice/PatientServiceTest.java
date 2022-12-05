package com.patientservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.patientservice.model.Patient;
import com.patientservice.repository.PatientRepository;
import com.patientservice.service.PatientServiceImpl;


@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
//	@Mock
//	private PatientService patientService;
//	
	@Mock
	private PatientRepository patientRepo;

	@InjectMocks
	private PatientServiceImpl patientServiceImpl;
	private Patient patient;

	@BeforeEach
	void setUp() {
		
//		patientRepo = Mockito.mock(PatientRepository.class);
//        patientServiceImpl = new PatientServiceImpl(patientRepo);
		patient = Patient.builder()
				.patientName("Sam")
				.DOB("09/07/22")
				.emailId("sam@gmail.com")
				.phoneNumber("8798574897")
				.drugId("51423-1542-21")
				.drugName("Cora500")
				.inductedStatus("INDUCTED")
				.build();
		patientRepo.save(patient);

	}

	@Test
	public void getPatientByNameTest() {
		when(patientServiceImpl.getPatientByName(patient.getPatientName())).thenReturn(patient);

		Patient searchedPatient = patientServiceImpl.getPatientByName(patient.getPatientName());

		assertThat(searchedPatient).isNotNull();
		assertThat(searchedPatient.getPatientName()).isEqualTo("Sam");
		assertThat(searchedPatient.getDOB()).isEqualTo("09/07/22");
		assertThat(searchedPatient.getDrugName()).isEqualTo("Cora500");

	}
	
	/*
	 * @Test public void updatePatientTest() { // Arrange Patient patient1 =
	 * Patient.builder() .patientName("Sam") .DOB("09/07/22")
	 * .emailId("sam@gmail.com") .phoneNumber("8798574897") .drugId("51423-1542-21")
	 * .drugName("Cora500") .inductedStatus("INDUCTED") .build();
	 * when(patientRepo.save(any(Patient.class))).thenReturn(patient1);
	 * patientServiceImpl.updatePatient(patient);
	 * 
	 * 
	 * patient1.setPatientName("Marc"); patient1.setEmailId("Marc@gmail.com");
	 * patientServiceImpl.updatePatient(patient); Patient updatedPatient =
	 * patientServiceImpl.getPatientByName(patient.getPatientName());
	 * assertThat(updatedPatient).isNotNull();
	 * assertThat(updatedPatient.getPatientName()).isEqualTo("Marc");
	 * assertThat(updatedPatient.getEmailId()).isEqualTo("Marc@gmail.com");
	 * 
	 * }
	 */

}