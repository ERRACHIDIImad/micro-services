import {Component, OnInit, ViewChild} from '@angular/core';
import {StudentsService} from "../services/students.service";
import {Payment} from "../model/model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-student-payments',
  templateUrl: './student-payments.component.html',
  styleUrl: './student-payments.component.css'
})
export class StudentPaymentsComponent implements OnInit {
  public dataSource!:MatTableDataSource<Payment> ;
  public displayedColumns : string[] = ['id', "date",'amount', 'type' , 'status' , 'fileLocation'];
  @ViewChild(MatPaginator)  paginator !:MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;
constructor (private router :Router , private studentService : StudentsService  , public activatedRoute : ActivatedRoute){}

  ngOnInit(): void {
    this.studentService.getPaymentOfStudent(this.activatedRoute.snapshot.params['code']).subscribe(
      {
        next: (data) =>{
            this.dataSource= new MatTableDataSource<Payment>(data);
            this.dataSource.paginator =  this.paginator;
            this.dataSource.sort=this.sorter;
        },
        error:err => {console.log(err);}
      });
  }

  public newPayment() : void {
      this.router.navigateByUrl(`admin/addPayment/${this.activatedRoute.snapshot.params['id']}/${this.activatedRoute.snapshot.params['code']}`);
    }

}
