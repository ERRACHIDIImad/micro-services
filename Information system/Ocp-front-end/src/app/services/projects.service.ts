import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {CommercialDivision, employee, Market, project} from "../model/model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class projectsService {
  constructor( private http : HttpClient) { }
  public getProjects() : Observable<Array<project>>{
    return this.http.get<Array<project>>(`${environment.backendHost}projects/all`);
  }

  public getProject(id : number) : Observable<project>{
    return this.http.get<project>(`${environment.backendHost}projects/${id}`);
  }

  public deleteProject(id:number) : Observable<any>{
    return this.http.delete(`${environment.backendHost}projects/delete/${id}`,{responseType:'text'});
  }


  public getEmployees(id : number) : Observable<employee> {
    return this.http.get<employee>(`${environment.backendHost}projects/${id}/employees`);
  }

  public saveProject(project : project) : Observable<project>{
    return this.http.post<project>(`${environment.backendHost}projects/Save`,project);
  }

  public updateProject(project: project):Observable<any>{
    return this.http.put(`${environment.backendHost}projects/Update`,project,{ responseType: 'text' });
  }
}


