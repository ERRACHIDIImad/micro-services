import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthentificationService} from "../services/authentification.service"
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent implements OnInit {
  @Output() onSubmitLoginEvent: EventEmitter<any> = new EventEmitter();
  public loginForm! : FormGroup ;

  constructor(private fb : FormBuilder, public authService: AuthentificationService,public router : Router) {}
  ngOnInit() : void {
    this.loginForm = this.fb.group(
      {
        username: this.fb.control(''),
        password: this.fb.control('')
      }
    );
  }

      public login() : void {
        let username = this.loginForm.value.username;
        let password = this.loginForm.value.password;
        if(this.authService.authentification(username,password))
        this.router.navigateByUrl("/admin");
  }
  }


