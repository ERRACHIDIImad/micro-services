import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {MarketService} from "../../services/market.service";
import {Market} from "../../model/model";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-add-market',
  templateUrl: './add-market.component.html',
  styleUrl: './add-market.component.css'
})
export class AddMarketComponent implements OnInit {
  marketform!: FormGroup;
  constructor(private fb: FormBuilder,private marketService: MarketService, private activatedRoute : ActivatedRoute){}

  ngOnInit(): void {
      this.createForm();
  }
  createForm() {
    this.marketform = this.fb.group({
      location: this.fb.control(''),
      name : this.fb.control(''),
      targetCustomers:this.fb.control('')
    });
  }

  addMarket() {
    const market: Market = {
      commercial_division_id: this.activatedRoute.snapshot.params['id'],
      location: this.marketform.value.location,
      targetCustomers: this.marketform.value.targetCustomers,
      name: this.marketform.value.name,

    }
    this.marketService.saveMarket(market).subscribe({
      next: (data) => {
      alert("Market added successfully")
        this.marketform.reset()
      },
      error: (err) => {
        console.log(err)
      }

    });
  }
}
