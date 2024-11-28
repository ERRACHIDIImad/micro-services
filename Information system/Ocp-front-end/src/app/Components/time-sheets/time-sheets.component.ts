import {Component, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {ActivatedRoute, Router} from "@angular/router";
import {EmployeeService} from "../../services/employee.service";

@Component({
  selector: 'app-time-sheets',
  templateUrl: './time-sheets.component.html',
  styleUrl: './time-sheets.component.css'
})
export class TimeSheetsComponent {
  public displayedColumns: string[] = ['Date','workedHours'];
  public dataSource!: MatTableDataSource<any> ;
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;

  constructor(private router: Router, private employeeService: EmployeeService, public activatedRoute: ActivatedRoute) {
  }

  private load() {
    this.employeeService.getTimeSheets(this.activatedRoute.snapshot.params['id']).subscribe(
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
}
