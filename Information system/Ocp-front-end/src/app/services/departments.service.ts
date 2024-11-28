import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {CommercialDivision, department, employee, Market} from "../model/model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class DepartmentsService {

  constructor( private http : HttpClient) { }
  public getDepartments() : Observable<Array<department>>{
    return this.http.get<Array<department>>(`${environment.backendHost}departments/all`);
  }

  public getDepartment(id : number) : Observable<department>{
    return this.http.get<department>(`${environment.backendHost}departments/${id}`);
  }

  public deleteDepartment(id : number) : Observable<any>{
    return this.http.delete(`${environment.backendHost}departments/delete/${id}`,{responseType:'text'});
  }
  public getemployees(id : number) : Observable<Array<employee>>{
    return this.http.get<Array<employee>>(`${environment.backendHost}departments/${id}/employees`);
  }

  public updateDepatment(Department: department,id:number) : Observable<any>{
    return this.http.put(`${environment.backendHost}departments/Update/${id}`,Department,{responseType:'text'});
  }

  public saveDepartment(Department: department):Observable<department>{
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<department>(`${environment.backendHost}departments/Save`,Department,{headers});
  }

}
