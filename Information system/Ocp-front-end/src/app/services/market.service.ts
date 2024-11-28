import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import {Observable} from "rxjs";
import {CommercialDivision, Market} from "../model/model";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class MarketService {

  constructor( private http : HttpClient) { }
  public deleteMarket(id:number) : Observable<any>{
    return this.http.delete(`${environment.backendHost}Markets/delete/${id}`,{responseType:'text'});
  }

  public saveMarket(market : Market) : Observable<Market>{
    return this.http.post<Market>(`${environment.backendHost}Markets/Save`,market);
  }

  public getMarkets(id : number) : Observable<Array<Market>>{
    return this.http.get<Array<Market>>(`${environment.backendHost}commercialDivisions/${id}/markets`);
  }

  public getMarket(id : number) : Observable<Market>{
    return this.http.get<Market>(`${environment.backendHost}Markets/${id}`);
  }

  public updateMarket(id:number,market: Market):Observable<any>{
    return this.http.put(`${environment.backendHost}Markets/Update/${id}`,market,{ responseType: 'text' });
  }
}
