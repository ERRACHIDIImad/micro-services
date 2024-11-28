import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {projectsService} from "../../services/projects.service";
import {DepartmentsService} from "../../services/departments.service";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrl: './employees.component.css'
})
export class EmployeesComponent implements OnInit , OnChanges{
  @Input() projectId!: number;
  @Input() departmentId!: number;
  public dataSource! : MatTableDataSource<any> ;
  public displayedColumns : string[] = ['Name','Position','Tasks','TimeSheets','Actions'];
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;
  constructor(private employeeServices: EmployeeService,private projectsService: projectsService, private departmentServices:DepartmentsService,public activatedRoute:ActivatedRoute,private router : Router) {

  }


  private load1(){
      this.projectsService.getEmployees(this.projectId).subscribe({
        next : (data: any) => {
          console.log(data);
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator=this.paginator;
          this.dataSource.sort=this.sorter;

        },
        error : err => {console.log("error")}
      });
    }
  private load2(){
    this.departmentServices.getemployees(this.departmentId).subscribe({
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
      if(this.projectId!=null)    this.load1();
      if(this.departmentId!=null) this.load2();
    }


  ngOnChanges(changes: SimpleChanges): void {
    if (changes['projectId'] && !changes['projectId'].firstChange) {
      this.load1();
    }
    if (changes['departmentId'] && !changes['departmentId'].firstChange) {
      this.load2();
    }
  }
  deleteEmployee(id:number){
    this.employeeServices.deleteEmployee(id).subscribe({
      next:(data)=>{
        alert("Employee deleted successfully")
        if(this.projectId!==null)this.load1();
        if(this.departmentId!==null) this.load2();
      },
      error:(err)=>alert("Not found")
    })  }


  addEmployee(deptId:number){
    this.router.navigateByUrl(`/admin/addEmployee/${deptId}`);
  }

  update(id:number){
    this.router.navigateByUrl(`/admin/updateEmployee/${id}`);
  }



  getTasks(id:number){
    this.router.navigateByUrl(`/admin/Tasks/${id}`);
  }

  getProjects(id:number){
    this.router.navigateByUrl(`/admin/Projects/${id}`);
  }
  getTimeSheets(id:number){
    this.router.navigateByUrl(`/admin/TimeSheets/${id}`);


  }
}
