import {Component, ViewChild} from '@angular/core';
import {CommercialDivision, Payment, Student} from "../../model/model";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {ActivatedRoute, Router} from "@angular/router";
import {CommercialDivisionService} from "../../services/commercial-division.service";

@Component({
  selector: 'app-commercial-division',
  templateUrl: './commercial-division.component.html',
  styleUrl: './commercial-division.component.css'
})
export class CommercialDivisionComponent {
  public selectedcom_divId: number | null = null;

  public dataSource!:  MatTableDataSource<any>;
  public displayedColumns: string[] = ['name', "Location", 'salesStrategy', "customerRelations", "Update", "Markets", "Delete"];
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;

  constructor(private router: Router, private comercialService: CommercialDivisionService, public activatedRoute: ActivatedRoute) {
  }

  private load() {
    this.comercialService.getCommecialDivisions().subscribe(
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

  public addComDiv(): void {
    this.router.navigateByUrl(`/admin/addCommercialDivision`);
  }

  public deleteComDiv(id: number): void {
    this.comercialService.deleteCommecialDivision(id).subscribe(
      {
        next: (data) => {
          this.load();
        },
        error: (err) => {
          console.log(err);
        }
      });
  }

  public updateComDiv(id: number) {
    this.router.navigateByUrl(`/admin/updatecommercialdivision/${id}`)
  }

  public getMarkets(id: number) {
    this.selectedcom_divId = id;
  }
}
