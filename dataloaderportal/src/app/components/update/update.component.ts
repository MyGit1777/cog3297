import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/patient';
import { PatientServiceService } from 'src/app/services/patient-service.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {
  patient = new Patient();
  constructor(private route: Router, private actRoute: ActivatedRoute, private patientService: PatientServiceService,
    private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.patient.patientId = this.actRoute.snapshot.params['patientId'];
    this.patient.patientName = this.actRoute.snapshot.params['patientName'];
    this.patient.emailId = this.actRoute.snapshot.params['emailId'];
    this.patient.dob = this.actRoute.snapshot.params['dob'];
    this.patient.address = this.actRoute.snapshot.params['address'];
    this.patient.phoneNumber = this.actRoute.snapshot.params['phoneNumber'];
    console.log("This is received upate patient:"+ this.patient.patientName);
  }

  updatePatient(){
    this.patientService.updatePatientDetails(this.patient).subscribe
      (
        data => {
          console.log("Data updated successfully");
          alert("Data updated successfully");
          this.route.navigate(['home']);
        },
        error =>{ console.log("Error while updating patient details");
        alert("Data updation failed");
      }
      )
  }
  gotoHome(){
    return this.route.navigate(['home']);

  }
}
