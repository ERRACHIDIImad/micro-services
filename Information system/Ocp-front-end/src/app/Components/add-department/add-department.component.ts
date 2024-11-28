import { Component } from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CommercialDivisionService} from "../../services/commercial-division.service";
import {CommercialDivision, department} from "../../model/model";
import {DepartmentsService} from "../../services/departments.service";
import {MatButton} from "@angular/material/button";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-add-department',
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
  templateUrl: './add-department.component.html',
  styleUrl: './add-department.component.css'
})
export class AddDepartmentComponent {
  departmentForm!: FormGroup;

  constructor(private fb: FormBuilder, private departmentsService: DepartmentsService) { }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.departmentForm = this.fb.group({
      name : this.fb.control(''),
    });
  }

  onSubmit() {
    const formdata:department =  {
      name:this.departmentForm.value.name,
    }

    // Send the data to the server
    this.departmentsService.saveDepartment(formdata).subscribe({
      next: (data: any) => {
        alert('Department saved successfully:');
        this.departmentForm.reset();
      },
      error : err => {console.error('Error saving department:', err)}
    });
}}
