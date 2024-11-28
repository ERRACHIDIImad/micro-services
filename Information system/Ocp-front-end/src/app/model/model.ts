export interface Student{
  id:number,
  firsName:string,
  lastName :string,
  code:string,
  photo:string,
  programId:string
}


export interface Payment{
  id : number,
  date: string,
  amount: number,
  type: string,
  status : string,
  fileLocation:string,
  student : Student
}

export enum paymentType{
  CASH, CHECK, TRANSFERT , DEPOSIT
}
export enum paymentStatus{
  CREATED, VALIDATED, REJECTED
}


export interface CommercialDivision{
  location:string,
  name:string,
  salesStrategy:string,
  customerRelations:String[]
}


export interface industrialDivision{
  id:number,
  location:string,
  name:string,
  qualityControl:string,
  processImprovements:string
}

export interface miningDivision{
  id:number,
  location:string,
  name:string,
  safetyStandards:string,
  environmentalPolicy:string,
  explorationBudget:number
}

export interface department{
  name:string
}

export interface employee{
  id:number
  name:string,
  position:string
  department_id:number;
}

export interface TimeSheet{
  id:number,
  hoursWorked:boolean,
  date : Date
}


export interface project{
  id:number,
  projectName:string,
  startDate : Date,
  endDate: Date
}
export interface Task {
    taskName:string,
    description:string,
    deadline:string,
    completed:string,
    project_id:string,
    employee_id:string
}

export interface Market {
  commercial_division_id :number,
  location :string,
  targetCustomers: string ,
  name:string
}
