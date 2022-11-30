import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PatientServiceService } from 'src/app/services/patient-service.service';

@Component({
  selector: 'app-induct-patient',
  templateUrl: './induct-patient.component.html',
  styleUrls: ['./induct-patient.component.css']
})
export class InductPatientComponent implements OnInit {
  selectedFile: any
  constructor(private route: Router, private patientService: PatientServiceService) { }

  ngOnInit(): void {
  }
  inductPatient() {
    const uploadData = new FormData();
    uploadData.append('file', this.selectedFile);
    this.patientService.uploadData(uploadData).subscribe
      (
        (data: any) => {
          console.log("Data uploaded successfully");
          alert("Data uploaded successfully");
          this.route.navigate(['home']);
        },
        error => {
          console.log("Error while uploading data");
          alert("Data uploading failed");
        }
      )
  }

  gotoHome() {
    return this.route.navigate(['home']);
  }

  public onFileChanged(event: any) {
    console.log(event);
    this.selectedFile = event.target.files[0];

  }
}
