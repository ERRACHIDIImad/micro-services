import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {Observable, of} from "rxjs";
import {environment} from "../../environments/environment";
import {Payment, Student} from "../model/model";
@Injectable({
  providedIn: 'root'
})

export class StudentsService {

  constructor( private http : HttpClient) { }
  public getStudents() : Observable<Array<Student>>{
    return this.http.get<Array<Student>>(`${environment.backendHost}user/Students`);
  }

  public getPayments() : Observable<Array<Payment>>{
    return this.http.get<Array<Payment>>(`${environment.backendHost}user/Payments`);
  }

  public getPaymentOfStudent(code: String) : Observable<Array<Payment>>{
      return this.http.get<Array<Payment>>(`${environment.backendHost}user/Student/${code}/Payments`);
  }

  public getPaymentDetails(id : number) : Observable<Blob>  {
    return  this.http.get(`${environment.backendHost}user/getFile/${id}`,{responseType:'blob'});
  }

  public savePayment(paymentData : FormData) : Observable<Payment> {
      return this.http.post<Payment>(`${environment.backendHost}admin/SavePayment`, paymentData);
  }
}
