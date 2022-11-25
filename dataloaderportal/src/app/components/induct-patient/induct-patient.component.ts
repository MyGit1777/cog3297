import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-induct-patient',
  templateUrl: './induct-patient.component.html',
  styleUrls: ['./induct-patient.component.css']
})
export class InductPatientComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  inductPatient(){


  }

  gotoHome(){


  }

  public onFileChanged(event:any) {
    console.log(event);
    // this.selectedFile = event.target.files[0];

    // // Below part is used to display the selected image
    // let reader = new FileReader();
    // reader.readAsDataURL(event.target.files[0]);
    // reader.onload = (event2) => {
    //   this.imgURL = reader.result;
    // };

  }
}
