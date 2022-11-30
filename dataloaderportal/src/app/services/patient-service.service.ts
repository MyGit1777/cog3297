import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Patient } from '../patient';

@Injectable({
  providedIn: 'root'
})
export class PatientServiceService {


  url = 'http://localhost:8081/dataloader';
  constructor(private http: HttpClient) { }


  getPatient(patientName: string): Observable<any> {
    return this.http.get<Patient>(`${this.url}/getPatient/` + patientName);
  }
  uploadData(data: any) {
    return this.http.post(`${this.url}/uploadData`, data)
  }

  updatePatientDetails(patient: Patient) {
    return this.http.put(`${this.url}/updatePatient`, patient)
  }


}
