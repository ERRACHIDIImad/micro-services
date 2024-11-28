import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, NgForm} from "@angular/forms";
import {ActivatedRoute} from "@angular/router";
import {StudentsService} from "../services/students.service";
import {paymentStatus, paymentType} from "../model/model";

@Component({
  selector: 'app-add-payment',
  templateUrl: './add-payment.component.html',
  styleUrl: './add-payment.component.css'
})
export class AddPaymentComponent implements OnInit{
  public PaymentForm! : FormGroup;
  public TypeEnumeration : String[]=[];
  public statusEnum : String[]=[];
  public file! : any;
  constructor(private service : StudentsService, private fb : FormBuilder , private  activatedRoute:ActivatedRoute){}

    ngOnInit(): void {
      for (let elt in paymentStatus){
        if(typeof paymentStatus[elt] === 'string')
        this.statusEnum.push(paymentStatus[elt]);
      }
      for(let elt in paymentType){
        if(typeof paymentType[elt] == 'string')
          this.TypeEnumeration.push(paymentType[elt]);
      }
        this.PaymentForm = this.fb.group(
          {
            date:this.fb.control(''),
            amount:this.fb.control(''),
            type:this.fb.control(''),
            status:this.fb.control(''),
            fileName:this.fb.control(''),
      });
    }
      //File uploader to the payment Form
      public onFileSelected(event : any): void {
          if (event.target.files.length > 0) {
            this.file = event.target.files[0];
            this.PaymentForm.patchValue({
              fileName: this.file.name
            });
        }
  }


    public addPayment(){
    let date : Date = new Date(this.PaymentForm.value.date);
        let  formdata : FormData = new FormData();
        formdata.set('id', JSON.stringify(0));
        formdata.set('file', this.file);
        formdata.set('date',date.getDay()+"/"+(date.getMonth()+1)+"/"+date.getFullYear());
        formdata.set('amount',this.PaymentForm.value.amount);
        formdata.set('type',this.PaymentForm.value.type);
        formdata.set('status',this.PaymentForm.value.status);
        formdata.set('StudentId',this.activatedRoute.snapshot.params['id']);

        this.service.savePayment(formdata).subscribe({
            next:  (value) => alert("Payment added successfully"),
            error: err => console.log(err)
          }
      );
  }
}
