package com.patientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.patientservice.helper.ExcelToDBHelper;
import com.patientservice.model.Patient;
import com.patientservice.service.PatientService;

@RestController
@CrossOrigin("*")
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/uploadData")
	public boolean upload(@RequestParam("file") MultipartFile file) {
		if (ExcelToDBHelper.checkFileFormat(file)) {

			this.patientService.savePatientData(file);
			return true;
//			return ResponseEntity.ok("Data saved successfully");
		}
		return false;
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Something went wrong, please check file format");
	}

	@GetMapping("/getAllPatients")
	public List<Patient> getAllPatients() {
		return this.patientService.getAllPatients();
	}

	@GetMapping("/getByPatientName/{patientName}")
	public ResponseEntity<Object> getPatientByName(@PathVariable("patientName") String patientName) {
		return new ResponseEntity<>(this.patientService.getPatientByName(patientName), HttpStatus.OK);
	}
	
	@PutMapping("/updatePatient")
	public ResponseEntity<Object> updatePatient(@RequestBody Patient patient) {

		this.patientService.updatePatient(patient);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
