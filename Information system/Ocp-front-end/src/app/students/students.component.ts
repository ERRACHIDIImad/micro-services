import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import { HttpClient } from "@angular/common/http";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {StudentsService} from "../services/students.service";
import {Student} from "../model/model";
import {Router} from "@angular/router";
@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrl: './students.component.css'
})

export class StudentsComponent implements OnInit {
  public dataSource! : MatTableDataSource<Student> ;
  public displayedColumns : string[] = ['id','firstName', 'lastName' , 'code' , 'programId','Payments'];
  public students! :  Array<Student>;
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !:MatSort;
  constructor(private router:Router, private studentsService : StudentsService){
    this.dataSource = new MatTableDataSource();
  }

  ngOnInit() {
    this.studentsService.getStudents().subscribe(
      {
        next : (data: Array<Student> ) => {
          this.students = data;
          console.log(this.students);
          this.dataSource = new MatTableDataSource<Student>(data);
          this.dataSource.paginator = this.paginator;
          this.dataSource.sort = this.sorter;
        },
        error : err => {console.log("error")}
         }
    );
  }
  public getPayments(id: number, code: string):void {
    this.router.navigateByUrl(`admin/StudentPayments/${id}/${code}`);
  }

}
