import { Component } from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MarketService} from "../../services/market.service";
import {ActivatedRoute} from "@angular/router";
import {employee, Market} from "../../model/model";
import {EmployeeService} from "../../services/employee.service";
import {MatButton} from "@angular/material/button";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-add-employee',
  standalone: true,
  imports: [
    FormsModule,
    MatButton,
    MatCard,
    MatCardActions,
    MatCardContent,
    MatCardHeader,
    MatCardTitle,
    MatDivider,
    MatFormField,
    MatInput,
    MatLabel,
    ReactiveFormsModule
  ],
  templateUrl: './add-employee.component.html',
  styleUrl: './add-employee.component.css'
})
export class AddEmployeeComponent {
  Employeeform!: FormGroup;
  constructor(private fb: FormBuilder,private employeeService: EmployeeService, private activatedRoute : ActivatedRoute){}

  ngOnInit(): void {
    this.createForm();
  }
  createForm() {
    this.Employeeform = this.fb.group({
      position: this.fb.control(''),
      name : this.fb.control(''),
    });
  }


  addEmpolyee() {
    const employee: employee = {
      id: 0,
      name: this.Employeeform.value.name,
      position: this.Employeeform.value.position,
      department_id: this.activatedRoute.snapshot.params['deptId'],

    }
    this.employeeService.saveEmployee(employee).subscribe({
      next: (data) => {
        alert("Employee added successfully")
        this.Employeeform.reset()
      },
      error: (err) => {
        console.log(err)
      }

    });
}}
