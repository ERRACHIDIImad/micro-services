import {Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {CommercialDivisionService} from "../../services/commercial-division.service";
import {MarketService} from "../../services/market.service";
import {ActivatedRoute, Router} from "@angular/router";
import {projectsService} from "../../services/projects.service";

@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrl: './projects.component.css'
})
export class ProjectsComponent {
  public selectedProjectId:number | null = 1;
  public dataSource! : MatTableDataSource<any> ;
  public displayedColumns : string[] = ['projectName','startDate', 'endDate','actions' ,'employees'];
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;
  constructor(private projectsService: projectsService, public activatedRoute:ActivatedRoute,private router : Router) {
  }

  private load(){
    this.projectsService.getProjects().subscribe({
      next : (data: any) => {
        console.log(data);
        this.dataSource = new MatTableDataSource(data);
        this.dataSource.paginator=this.paginator;
        this.dataSource.sort=this.sorter;

      },
      error : err => {console.log("error")}
    });
  }
  ngOnInit(): void {
    this.load();
  }
  delete(id:number) {
    this.projectsService.deleteProject(id).subscribe(
      {
        next: (data) => {
          this.load();
        },
        error: (err) => {
          console.log(err);
        }
      });
  }
  public getEmployees(id : number): void {
    this.selectedProjectId=id;
  }

  addProject() {
    this.router.navigateByUrl(`/admin/addProject`);
   }

  update(id: number ) {
    this.router.navigateByUrl(`/admin/updateProject/${id}`);
  }
}
