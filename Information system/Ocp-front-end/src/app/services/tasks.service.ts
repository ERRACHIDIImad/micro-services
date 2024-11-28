import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Market, Task} from "../model/model";

@Injectable({
  providedIn: 'root'
})
export class TasksService {

  constructor( private http : HttpClient) { }

  public deleteTask(id:number) : Observable<any>{
      return this.http.delete(`${environment.backendHost}tasks/delete/${id}`,{responseType:'text'});
    }

  public saveTask(task : Task) : Observable<Task>{
      return this.http.post<Task>(`${environment.backendHost}tasks/Save`,task);
    }

  public getMarkets(id : number) : Observable<Array<Market>>{
      return this.http.get<Array<Market>>(`${environment.backendHost}commercialDivisions/${id}/markets`);
    }

  public getMarket(id : number) : Observable<Market>{
      return this.http.get<Market>(`${environment.backendHost}Markets/${id}`);
    }

  public updateMarket(id:number,market: Market):Observable<any>{
      return this.http.put(`${environment.backendHost}Markets/Update/${id}`,market,{ responseType: 'text' });
    }  }
