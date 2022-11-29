import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Patient } from 'src/app/patient';
import { PatientServiceService } from 'src/app/services/patient-service.service';

@Component({
  selector: 'app-view-update',
  templateUrl: './view-update.component.html',
  styleUrls: ['./view-update.component.css']
})
export class ViewUpdateComponent implements OnInit {
  patientName!:string
  patient = new Patient();
  constructor(private router: Router, private patientService: PatientServiceService) { }

  ngOnInit(): void {
  }

  getPatientDetails(){
    this.patientService.getPatient(this.patientName).subscribe(data => {
      console.log("This is returned patient"+ data);
      this.patient = data;
      console.log("This is returned patient :" + this.patient.patientName);
    }, error => console.log(error));

  }
  gotoHome() {
   return this.router.navigate(['home']);

  }
  updatePatient(){
    let patientUpdate=  this.patient
    console.log("inside update patient" + this.patient.patientName);
    this.router.navigate(['/updatePatient', patientUpdate]);

  }
}
