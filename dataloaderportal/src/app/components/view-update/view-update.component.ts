import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Patient } from 'src/app/patient';
import { PatientServiceService } from 'src/app/services/patient-service.service';

@Component({
  selector: 'app-view-update',
  templateUrl: './view-update.component.html',
  styleUrls: ['./view-update.component.css']
})
export class ViewUpdateComponent implements OnInit {
  patientName!: string
  patient = new Patient();
  flowName: any;
  waitingFlag= false;
  constructor(private router: Router,private actRoute: ActivatedRoute, private patientService: PatientServiceService) { }

  ngOnInit(): void {
    this.flowName = this.actRoute.snapshot.params['flowname'];
    console.log("flow name:"+ this.flowName);

  }

  getPatientDetails() {
    this.patientService.getPatient(this.patientName).subscribe(data => {
      console.log("This is returned patient" + data);
      this.patient = data;
      console.log("This is returned patient :" + this.patient.patientName);
    }, error => {      
      console.log(error)
    alert("Something went wrong, could not find patient!");
    });

  }
  gotoHome() {
    return this.router.navigate(['home']);

  }
  updatePatient() {
    let patientUpdate = this.patient
    this.patient.inductedStatus='INDUCTED'
    console.log("inside update patient" + this.patient.patientName);
    this.router.navigate(['/updatePatient', patientUpdate]);

  }

  processData(){
    this.waitingFlag=true;
    this.patient.inductedStatus='PROCESSED'
    let patientProcess = this.patient
    this.patientService.updatePatientDetails(patientProcess).subscribe(data => {
      this.waitingFlag=false;
      console.log("Data processed successfully");
      alert("Data processed successfully!");
      this.router.navigate(['home']);
    }, error => {

      console.log("Data processing failed")
      alert("Data processing failed");
    }
    
    );
    
  }
}
