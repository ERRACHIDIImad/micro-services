import { Component } from '@angular/core';
import {AuthentificationService} from "../services/authentification.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-template',
  templateUrl: './admin-template.component.html',
  styleUrl: './admin-template.component.css'
})
export class AdminTemplateComponent {
  public username:any = undefined;
  public roles: any[];

    constructor( public authService: AuthentificationService , private router:Router) {
      this.username = this.authService.getUsername();
      this.roles = authService.getRoles();
    }

    public logout(){
      this.username=undefined;
      this.roles=[];
      this.authService.logOut();
      this.router.navigateByUrl("/login");
    }

}
