import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {MarketService} from "../../services/market.service";
import {Market} from "../../model/model";

@Component({
  selector: 'app-update-market',
  templateUrl: './update-market.component.html',
  styleUrl: './update-market.component.css'
})
export class UpdateMarketComponent {
  marketForm!: FormGroup;

  constructor(private fb: FormBuilder, private marketService: MarketService, private activatedroute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.marketForm = this.fb.group({
      location: this.fb.control(''),
      name: this.fb.control(''),
      targetCustomers: this.fb.control('')
    });

    this.marketService.getMarket(this.activatedroute.snapshot.params['id']).subscribe({
      next:(data) =>{
        console.log(data)
        this.marketForm.patchValue({
          location: data.location,
          name: data.name,
          targetCustomers: data.targetCustomers
        }  );

      },
      error : err => console.log("error updating")
    });
  }
  public update():void {


    const market: Market = {
      commercial_division_id:this.activatedroute.snapshot.params['id_com_div'],
      location:this.marketForm.value.location,
      name:this.marketForm.value.name,
      targetCustomers:this.marketForm.value.targetCustomers
    }
    console.log(market)
    this.marketService.updateMarket(this.activatedroute.snapshot.params['id'],market).subscribe({
      next : data => {
        alert("Market updated successfully")
        this.marketForm.reset()
      },
      error:(err) =>{console.log(err)}
    });
  }

}
