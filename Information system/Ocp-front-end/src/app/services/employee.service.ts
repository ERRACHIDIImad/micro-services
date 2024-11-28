import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {department, employee, project, Task, TimeSheet} from "../model/model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor( private http : HttpClient) { }
  public getEmployees() : Observable<Array<employee>>{
    return this.http.get<Array<employee>>(`${environment.backendHost}employees/all`);
  }

  public getEmployee(id : number) : Observable<employee>{
    return this.http.get<employee>(`${environment.backendHost}employees/${id}`);
  }

  public deleteEmployee(id : number) : Observable<any>{
    return this.http.delete(`${environment.backendHost}employees/delete/${id}`,{responseType:'text'});
  }

  public updateEmployee(Employee: employee) : Observable<any>{
    return this.http.put(`${environment.backendHost}employees/Update`,Employee,{responseType:'text'});
  }

  public saveEmployee(Employee: employee):Observable<employee>{
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<employee>(`${environment.backendHost}employees/Save`,Employee,{headers});
  }



  public getTimeSheets(id : number) : Observable<Array<TimeSheet>>{
    return this.http.get<Array<TimeSheet>>(`${environment.backendHost}employees/${id}/timesheets`);
  }

  public getProjects(id : number) : Observable<Array<project>>{
    return this.http.get<Array<project>>(`${environment.backendHost}employees/${id}/projects`);
  }

  public getTasks(id : number) : Observable<Array<Task>>{
    return this.http.get<Array<Task>>(`${environment.backendHost}employees/${id}/tasks`);
  }




}
