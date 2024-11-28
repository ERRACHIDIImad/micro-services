import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentsComponent} from "./students/students.component";
import {PaymentsComponent} from "./payments/payments.component";
import {LoginComponent} from "./login/login.component";
import {AdminTemplateComponent} from "./Template/admin-template.component";
import {authGuard} from "./Guards/auth-guard.guard";
import {authorizationGuardGuard} from "./Guards/authorization-guard.guard";
import {StudentPaymentsComponent} from "./student-payments/student-payments.component";
import {AddPaymentComponent} from "./add-payment/add-payment.component";
import {AddCommercialDivisionComponent} from "./Components/add-commercial-division/add-commercial-division.component";
import {
  UpdateCommercialDivisionComponent
} from "./Components/update-commercial-division/update-commercial-division.component";
import {MarketsComponent} from "./Components/markets/markets.component";
import {CommercialDivisionComponent} from "./Components/commercial-division/commercial-division.component";
import {AddMarketComponent} from "./Components/add-market/add-market.component";
import { UpdateMarketComponent } from './Components/update-market/update-market.component';
import {ProjectsComponent} from "./Components/projects/projects.component";
import {AddProjectComponent} from "./Components/add-project/add-project.component";
import {UpdateProject} from "@angular/cdk/schematics";
import {UpdateProjectComponent} from "./Components/update-project/update-project.component";
import {DepartmentsComponent} from "./Components/departments/departments.component";
import {AddDepartmentComponent} from "./Components/add-department/add-department.component";
import {UpdateDepartmentComponent} from "./Components/update-department/update-department.component";
import {AddEmployeeComponent} from "./Components/add-employee/add-employee.component";
import {UpdateEmployeeComponent} from "./Components/update-employee/update-employee.component";
import {TasksComponent} from "./Components/tasks/tasks.component";
import {TimeSheetsComponent} from "./Components/time-sheets/time-sheets.component";

const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "login", component: LoginComponent},
  {  path: "admin", canActivate:[authGuard], component: AdminTemplateComponent , children : [
    {path: "students", component: StudentsComponent ,canActivate:[authorizationGuardGuard] , data:{roles : 'ADMIN'} ,},
    {path: "projects" , component: ProjectsComponent},
    {path: "payments" , component: PaymentsComponent},
    {path:"StudentPayments/:id/:code" ,component:StudentPaymentsComponent},
    {path:"addPayment/:id/:code" ,component:AddPaymentComponent},
    {path: "loadStudents",canActivate:[authorizationGuardGuard] , data:{roles : 'ADMIN'} ,component: StudentsComponent},
    {path: "addCommercialDivision", component:AddCommercialDivisionComponent},
    {path: "updatecommercialdivision/:id", component: UpdateCommercialDivisionComponent },
    {path: "Markets/:id", component: MarketsComponent },
    {path: "commercial-division", component:CommercialDivisionComponent},
    {path: "addMarket/:id", component:AddMarketComponent},
    {path: "updateMarket/:id/:id_com_div", component:UpdateMarketComponent},
    {path: "addProject", component:AddProjectComponent},
    {path: "updateProject/:id", component:UpdateProjectComponent},
    {path: "departments", component:DepartmentsComponent},
    {path: "addDepartment", component:AddDepartmentComponent},
    {path: "updateDepartment/:id", component: UpdateDepartmentComponent},
    {path: "addEmployee/:deptId", component: AddEmployeeComponent},
    {path: "updateEmployee/:id", component: UpdateEmployeeComponent},
    {path: "Tasks/:id", component: TasksComponent},
    {path: "Projects/:id", component: ProjectsComponent},
    {path: "TimeSheets/:id", component: TimeSheetsComponent},

    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
