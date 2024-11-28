import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommercialDivisionService } from '../../services/commercial-division.service';
import {F} from "@angular/cdk/keycodes";
import {CommercialDivision} from "../../model/model";

@Component({
  selector: 'app-add-commercial-division',
  templateUrl: './add-commercial-division.component.html',
  styleUrls: ['./add-commercial-division.component.css']
})
export class AddCommercialDivisionComponent implements OnInit {
  commercialForm!: FormGroup;
  CustomerRelations:String[]=[] ;

  constructor(private fb: FormBuilder, private commercialService: CommercialDivisionService) { }

  ngOnInit(): void {
    this.createForm();
  }
 private  addRealtion(relation: string){
  if(relation.length!=0)
    this.CustomerRelations.push(relation);
  }

  createForm() {
    this.commercialForm = this.fb.group({
      location: this.fb.control(''),
      name : this.fb.control(''),
      salesStrategy:this.fb.control(''),
      relation1:this.fb.control(''),
      relation2:this.fb.control(''),
      relation3:this.fb.control(''),
    });
  }

  onSubmit() {
    this.addRealtion(this.commercialForm.value.relation1);
    this.addRealtion(this.commercialForm.value.relation2);
    this.addRealtion(this.commercialForm.value.relation3);
    const formdata:CommercialDivision =  {
      name:this.commercialForm.value.name,
      location : this.commercialForm.value.location,
      salesStrategy:this.commercialForm.value.salesStrategy,
      customerRelations:this.CustomerRelations
    }

    // Send the data to the server
    this.commercialService.SaveCommercialDivision(formdata).subscribe({
      next: (data: any) => {
        alert('Commercial division saved successfully:');
        this.commercialForm.reset();
        this.CustomerRelations=[];
      },
      error : err => {console.error('Error saving commercial division:', err)}
    });

  }
}
