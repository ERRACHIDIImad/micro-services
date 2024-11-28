import { Component } from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {projectsService} from "../../services/projects.service";
import {ActivatedRoute} from "@angular/router";
import {DepartmentsService} from "../../services/departments.service";
import {department} from "../../model/model";
import {MatButton} from "@angular/material/button";
import {MatCard, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatFormField, MatLabel, MatSuffix} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";

@Component({
  selector: 'app-update-department',
  standalone: true,
  imports: [
    FormsModule,
    MatButton,
    MatCard,
    MatCardContent,
    MatCardHeader,
    MatCardTitle,
    MatDatepicker,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatFormField,
    MatInput,
    MatLabel,
    MatSuffix,
    ReactiveFormsModule
  ],
  templateUrl: './update-department.component.html',
  styleUrl: './update-department.component.css'
})
export class UpdateDepartmentComponent {
  departmentform!: FormGroup;

  constructor(private fb: FormBuilder, private departmentService: DepartmentsService, private activatedroute: ActivatedRoute) {}

  createForm() {
    this.departmentform = this.fb.group({
      name: this.fb.control('')
    });
  }
  ngOnInit(): void {
    this.createForm();
    this.departmentService.getDepartment(this.activatedroute.snapshot.params['id']).subscribe({
      next:(data) =>{
        console.log(data)
        this.departmentform.patchValue({
          name: data.name
        });

      },
      error : err => console.log("error updating")
    });
  }

  public update():void {

    const department: department = {
      name:this.departmentform.value.name
    }

    this.departmentService.updateDepatment(department,this.activatedroute.snapshot.params['id']).subscribe({
      next : data => {
        alert("Department updated successfully")
        this.departmentform.reset()
      },
      error:(err) =>{console.log(err)}
    });
  }
}
