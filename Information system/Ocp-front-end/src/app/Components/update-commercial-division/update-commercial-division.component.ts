import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {CommercialDivisionService} from "../../services/commercial-division.service";
import {CommercialDivision} from "../../model/model";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-update-commercial-division',
  templateUrl: './update-commercial-division.component.html',
  styleUrl: './update-commercial-division.component.css'
})
export class UpdateCommercialDivisionComponent {
   private commercialDivision!:CommercialDivision;
  commercialForm!: FormGroup;
  CustomerRelations:String[]=[] ;

  constructor(private fb: FormBuilder, private commercialService: CommercialDivisionService,private activatedroute:ActivatedRoute) { }

  ngOnInit(): void {
    this.commercialForm = this.fb.group({
      location: this.fb.control(''),
      name : this.fb.control(''),
      salesStrategy:this.fb.control(''),
      relation1:this.fb.control(''),
      relation2:this.fb.control(''),
      relation3:this.fb.control(''),
    });

     this.commercialService.getCommecialDivision(this.activatedroute.snapshot.params['id']).subscribe({
      next:(data) =>{
        console.log(data)
       // this.commercialDivision=data;
        this.commercialForm.patchValue({
          location: data.location,
          name: data.name,
          salesStrategy: data.salesStrategy,
          relation1:data.customerRelations[0]!=""?data.customerRelations[0]:"",
          relation2:data.customerRelations[1]!=""?data.customerRelations[1]:"",
          relation3:data.customerRelations[2]!=""?data.customerRelations[2]:""
        }  );

      },
      error : err => console.log("error updating")
    });


  }

  private  addRealtion(relation: string){
    if(relation!=null&&relation.length!=0)
      this.CustomerRelations.push(relation);
  }


public update() : void {
    this.addRealtion(this.commercialForm.value.relation1);
    this.addRealtion(this.commercialForm.value.relation2);
    this.addRealtion(this.commercialForm.value.relation3);
    const formdata:CommercialDivision =  {
      name:this.commercialForm.value.name,
      location : this.commercialForm.value.location,
      salesStrategy:this.commercialForm.value.salesStrategy,
      customerRelations:this.CustomerRelations
    }

    this.commercialService.updateCommercialDivision(this.activatedroute.snapshot.params['id'],formdata).subscribe({
      next: (data: any) => {
        alert('Commercial division updated successfully:');
        this.commercialForm.reset();
        this.CustomerRelations=[];
      },
      error : err => {console.error('Error updating commercial division:', err)}
    });

  }

}
