import {Component, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {ActivatedRoute, Router} from "@angular/router";
import {CommercialDivisionService} from "../../services/commercial-division.service";
import {DepartmentsService} from "../../services/departments.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-departments',
  templateUrl: './departments.component.html',
  styleUrl: './departments.component.css'
})
export class DepartmentsComponent {
  public department_Id: number | null = null;
  public displayedColumns: string[] = [ 'id','name','actions','employees'];
  public dataSource!: MatTableDataSource<any> ;
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;

  constructor(private router: Router, private departmentService: DepartmentsService, public activatedRoute: ActivatedRoute) {
  }

  private load() {
    this.departmentService.getDepartments().subscribe(
      {
        next: (data) => {
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
  public getEmployees(id: number) {
    this.department_Id = id;
  }








  public addDepartment(): void {
    this.router.navigateByUrl(`/admin/addDepartment`);
  }

  public deleteDeparmtent(id: number): void {
    this.departmentService.deleteDepartment(id).subscribe(
      {
        next: (data) => {
          this.load();
        },
        error: (err) => {
          console.log(err);
        }
      });
  }

  public updateDepartment(id: number) {
    this.router.navigateByUrl(`/admin/updateDepartment/${id}`)
  }


}
