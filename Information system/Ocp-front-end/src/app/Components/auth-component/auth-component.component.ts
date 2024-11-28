import { Component } from '@angular/core';
import {AuthentificationService} from '../../services/authentification.service';
import {NgForOf} from "@angular/common";
@Component({
  selector: 'app-auth-component',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './auth-component.component.html',
  styleUrl: './auth-component.component.css'
})
export class AuthComponentComponent {
  data : String[] = [];
  constructor(private authentificationService : AuthentificationService){}

    ngOnInit(): void {
      this.authentificationService.request(
      "GET",
      "/messages",
        {}
    ).then(
      (response) => this.data=response.data
    ).catch((error) => console.log("error fetching",error));


  }




}



