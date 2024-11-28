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
  selector: 'app-update-employee',
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
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent {
  employeeForm!: FormGroup;

  constructor(private fb: FormBuilder, private employeeService: EmployeeService, private activatedroute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.employeeForm = this.fb.group({
      position: this.fb.control(''),
      name: this.fb.control('')
    });

    this.employeeService.getEmployee(this.activatedroute.snapshot.params['id']).subscribe({
      next:(data) =>{
        console.log(data)
        this.employeeForm.patchValue({
          position: data.position,
          name: data.name
        });

      },
      error : err => console.log("error updating")
    });
  }
  public update():void {
    const employee: employee = {
      id:this.activatedroute.snapshot.params['id'],
      position:this.employeeForm.value.position,
      name:this.employeeForm.value.name,
      department_id:0
    }
    console.log(employee)
    this.employeeService.updateEmployee(employee).subscribe({
      next : data => {
        alert("Employee updated successfully")
        this.employeeForm.reset()
      },
      error:(err) =>{console.log(err)}
    });
  }
}
