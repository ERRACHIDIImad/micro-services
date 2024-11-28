import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {MarketService} from "../../services/market.service";
import {ActivatedRoute} from "@angular/router";
import {Market, project} from "../../model/model";
import {projectsService} from "../../services/projects.service";

@Component({
  selector: 'app-update-project',
  templateUrl: './update-project.component.html',
  styleUrl: './update-project.component.css'
})
export class UpdateProjectComponent implements OnInit {
  projectform!: FormGroup;

  constructor(private fb: FormBuilder, private projectService: projectsService, private activatedroute: ActivatedRoute) {}

  createForm() {
    this.projectform = this.fb.group({
      projectName: this.fb.control(''),
      startDate: this.fb.control(''),
      endDate: this.fb.control('')
    });
  }
  ngOnInit(): void {
    this.createForm();
    this.projectService.getProject(this.activatedroute.snapshot.params['id']).subscribe({
      next:(data) =>{
        console.log(data)
        this.projectform.patchValue({
          projectName: data.projectName,
          startDate: data.startDate,
          endDate: data.endDate
        }  );

      },
      error : err => console.log("error updating")
    });
  }

  public update():void {

    const project: project = {
      id:this.activatedroute.snapshot.params['id'],
      projectName:this.projectform.value.projectName,
      startDate:this.projectform.value.startDate,
      endDate:this.projectform.value.endDate
    }

    this.projectService.updateProject(project).subscribe({
      next : data => {
        alert("Project updated successfully")
        this.projectform.reset()
      },
      error:(err) =>{console.log(err)}
    });
  }
}
