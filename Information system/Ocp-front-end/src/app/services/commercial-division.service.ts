import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {CommercialDivision, Market, Student} from "../model/model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CommercialDivisionService {

  constructor( private http : HttpClient) { }
  public getCommecialDivisions() : Observable<Array<CommercialDivision>>{
    return this.http.get<Array<CommercialDivision>>(`${environment.backendHost}commercialDivisions/commercialDivisions`);
  }

  public getCommecialDivision(id : number) : Observable<CommercialDivision>{
    return this.http.get<CommercialDivision>(`${environment.backendHost}commercialDivisions/${id}`);
  }

  public getMarkets(id : number) : Observable<Array<Market>>{
    return this.http.get<Array<Market>>(`${environment.backendHost}commercialDivisions/${id}/markets`);
  }

  public deleteCommecialDivision(id : number) : Observable<any>{
    return this.http.delete(`${environment.backendHost}commercialDivisions/delete/${id}`,{responseType:'text'});
  }
  public SaveCommercialDivision(commercialDivision: CommercialDivision):Observable<CommercialDivision>{
    //const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
      return this.http.post<CommercialDivision>(`${environment.backendHost}commercialDivisions/addCommercialDivision`,commercialDivision,);
  }
  public updateCommercialDivision(id:number,commercialDivision: CommercialDivision):Observable<CommercialDivision>{
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put<CommercialDivision>(`${environment.backendHost}commercialDivisions/Update/${id}`,commercialDivision,{headers});
  }
}
