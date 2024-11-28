import { Injectable } from '@angular/core';
import {ThisReceiver} from "@angular/compiler";
import {HttpClient} from "@angular/common/http";
import axios from 'axios'
@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  private users: any;
  private username!: any;
  private roles!: String[];

  constructor() {
    this.users = {

      Errachidiimad: {password: "1234", roles: ["ADMIN", "USER"]},
      ErrachidiAfaf: {password: "1234", roles: ["ADMIN", "USER"]},
      ERRACHIDI: {password: "1234", roles: ["USER"]},
      Anass : {password: "1234", roles: ["USER"]},
      Achraf123 : {password: "1234", roles: ["USER"]},
    }
  }
     public authentification(username:any , password: any): any {
       if (this.users[username] && this.users[username]['password']==password) {
         this.username = username;
         this.roles = this.users[username]['roles'];
       }
         return this.username;
       }


  public logOut() : void {
    // this.username=undefined;
    // this.roles=[];
  }


  public getUsername():any{return this.username;}
  public getRoles(){
    return this.roles;
  }




}
