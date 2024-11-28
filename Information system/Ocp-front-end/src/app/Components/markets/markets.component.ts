import {Component, Input, OnChanges, OnInit, SimpleChanges, ViewChild} from '@angular/core';
import {CommercialDivisionService} from "../../services/commercial-division.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MatTableDataSource} from "@angular/material/table";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MarketService} from "../../services/market.service";

@Component({
  selector: 'app-markets',
  templateUrl: './markets.component.html',
  styleUrl: './markets.component.css'
})
export class MarketsComponent implements OnInit, OnChanges{
  @Input() comercialDivId!: number;
  public dataSource! : MatTableDataSource<any> ;
  public displayedColumns : string[] = ['name','location', 'targetCustomers' ,'Update','Delete'];
  @ViewChild(MatPaginator) paginator !: MatPaginator;
  @ViewChild(MatSort) sorter !: MatSort;
  constructor(private comercialService: CommercialDivisionService,private marketService :MarketService, public activatedRoute:ActivatedRoute,private router : Router) {

  }

  private load(){
    this.marketService.getMarkets(this.comercialDivId).subscribe({
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
  addMarket() {
    this.router.navigateByUrl(`/admin/addMarket/${this.comercialDivId}`);
  }




  deleteMarket(id:number) {
    this.marketService.deleteMarket(id).subscribe(
      {
        next: (data) => {
         this.load();
        },
        error: (err) => {
          console.log(err);
        }
      });
  }
  updateMarket(id: number ) {
    this.router.navigateByUrl(`/admin/updateMarket/${id}/${this.comercialDivId}`);

  }

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['comercialDivId'] && !changes['comercialDivId'].firstChange) {
      this.load();
    }
  }

}
