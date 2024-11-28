import {Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {ActivatedRoute, Router} from "@angular/router";
import {DepartmentsService} from "../../services/departments.service";
import {TasksService} from "../../services/tasks.service";
import {EmployeeService} from "../../services/employee.service";
import {HttpClient} from "@angular/common/http";
import {environment} from "../../../environments/environment";

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {
  public displayedColumns: string[] = ['taskName','description','deadLine','completed','actions'];
  public dataSource!: MatTableDataSource<any> ;
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;

  constructor(private  http:HttpClient,private router: Router, private TaskService :TasksService,private employeeService: EmployeeService, public activatedRoute: ActivatedRoute) {
  }

  private load() {
    this.employeeService.getTasks(this.activatedRoute.snapshot.params['id']).subscribe(
      {
        next: (data) => {
          console.log(data)
          this.dataSource = new MatTableDataSource(data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sorter;
        },
        error: err => {
          console.log(err);
        }
      });

  }
  ngOnInit(): void {
    this.load();
  }
  deleteTask(id : number):void{
this.TaskService.deleteTask(id).subscribe({
  next: (data:any)=> {
    alert("Task has been deleted successfully")
    this.load();
  },
  error:err => alert("Not found")
})
  }
  addTask(){
    this.router.navigateByUrl(`/admin/addTask/${this.activatedRoute.snapshot.params['id']}`);
  }
}
