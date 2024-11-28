import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {MarketService} from "../../services/market.service";
import {ActivatedRoute} from "@angular/router";
import {Market, project} from "../../model/model";
import {projectsService} from "../../services/projects.service";

@Component({
  selector: 'app-add-project',
  templateUrl: './add-project.component.html',
  styleUrl: './add-project.component.css'
})
export class AddProjectComponent {
  projectform!: FormGroup;
  constructor(private fb: FormBuilder, private projectService: projectsService, private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.createForm();
  }

  createForm() {
    this.projectform = this.fb.group({
      projectName: this.fb.control(''),
      startDate: this.fb.control(''),
      endDate: this.fb.control('')
    });
  }

  addProject() {
    const project: project = {
      id: 0,
      projectName:this.projectform.value.projectName,
      startDate:this.projectform.value.startDate,
      endDate:this.projectform.value.endDate
    }
    console.log(project)
    this.projectService.saveProject(project).subscribe({
      next: (data) => {
        alert("Project added successfully")
        this.projectform.reset()
      },
      error: (err) => {
        console.log(err)
      }

    });
  }
}
