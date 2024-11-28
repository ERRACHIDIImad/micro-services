import {Component, ViewChild} from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {StudentsService} from "../services/students.service";
import {Router, RouterModule} from "@angular/router";
import {environment} from "../../environments/environment.development";

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrl: './payments.component.css'
})
export class PaymentsComponent {
  public dataSource! : MatTableDataSource<any> ;
  public displayedColumns : string[] = ['id', 'amount' , 'type' , 'status' , 'fileLocation', 'paymentdetails'];
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;
  constructor(private studentsService : StudentsService,private router : Router){
    this.dataSource = new MatTableDataSource();
  }

  ngOnInit() {
    this.studentsService.getPayments().subscribe(
      {
        next : (data: any) => {
          this.dataSource = new MatTableDataSource(data);
          console.log(data);
          this.dataSource.paginator=this.paginator;
          this.dataSource.sort=this.sorter;
        },
        error : err => {console.log("error")}
      }
    );
  }

    public getPaymentDetails(id : number): void {
    this.router.navigateByUrl(`/admin/PaymentDetails/${id}`);
    }
}
