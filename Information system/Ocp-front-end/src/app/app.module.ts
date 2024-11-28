import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import {MatToolbar} from "@angular/material/toolbar";
import { AdminTemplateComponent } from './Template/admin-template.component';
import {MatButton, MatIconButton} from "@angular/material/button";
import {MatIcon} from "@angular/material/icon";
import {MatMenu, MatMenuItem, MatMenuTrigger} from "@angular/material/menu";
import {MatDrawer, MatDrawerContainer, MatDrawerContent} from "@angular/material/sidenav";
import {MatList, MatListItem} from "@angular/material/list";
import { StudentsComponent } from './students/students.component';
import { PaymentsComponent } from './payments/payments.component';
import {MatCard, MatCardActions, MatCardContent, MatCardHeader, MatCardTitle} from "@angular/material/card";
import { LoginComponent } from './login/login.component';
import {MatDivider} from "@angular/material/divider";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import { MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import {authGuard} from "./Guards/auth-guard.guard";
import {authorizationGuardGuard} from "./Guards/authorization-guard.guard";
import { MatTableModule} from "@angular/material/table";
import { provideHttpClient, withInterceptorsFromDi } from "@angular/common/http";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort, MatSortHeader} from "@angular/material/sort";
import {StudentPaymentsComponent } from './student-payments/student-payments.component';
import {AddPaymentComponent } from './add-payment/add-payment.component';
import {MatDatepicker, MatDatepickerInput, MatDatepickerToggle} from "@angular/material/datepicker";
import {MatNativeDateModule, MatOption} from "@angular/material/core";
import {MatSelect} from "@angular/material/select";
import { DepartmentsComponent } from './Components/departments/departments.component';
import { ProjectsComponent } from './Components/projects/projects.component';
import { EmployeesComponent } from './Components/employees/employees.component';
import { CommercialDivisionComponent } from './Components/commercial-division/commercial-division.component';
import { IndustrialDivisionComponent } from './Components/industrial-division/industrial-division.component';
import { MineComponent } from './Components/mine/mine.component';
import { MiningComponent } from './Components/mining/mining.component';
import { TasksComponent } from './Components/tasks/tasks.component';
import { TimeSheetsComponent } from './Components/time-sheets/time-sheets.component';
import { AddCommercialDivisionComponent } from './Components/add-commercial-division/add-commercial-division.component';
import { UpdateCommercialDivisionComponent } from './Components/update-commercial-division/update-commercial-division.component';
import { MarketsComponent } from './Components/markets/markets.component';
import { AddMarketComponent } from './Components/add-market/add-market.component';
import { UpdateMarketComponent } from './Components/update-market/update-market.component';
import { AddProjectComponent } from './Components/add-project/add-project.component';
import { UpdateProjectComponent } from './Components/update-project/update-project.component';
import {FormsModule} from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    AdminTemplateComponent,
    StudentsComponent,
    PaymentsComponent,
    LoginComponent,
    StudentPaymentsComponent,
    AddPaymentComponent,
    DepartmentsComponent,
    ProjectsComponent,
    EmployeesComponent,
    CommercialDivisionComponent,
    IndustrialDivisionComponent,
    MineComponent,
    MiningComponent,
    TasksComponent,
    TimeSheetsComponent,
    AddCommercialDivisionComponent,
    UpdateCommercialDivisionComponent,
    MarketsComponent,
    AddMarketComponent,
    UpdateMarketComponent,
    AddProjectComponent,
    UpdateProjectComponent,
  ],
  bootstrap: [AppComponent],
  imports: [BrowserModule,
    AppRoutingModule,
    MatToolbar,
    FormsModule,
    MatIconButton,
    MatButton,
    MatIcon,
    MatMenuTrigger,
    MatMenu,
    MatMenuItem,
    MatDrawerContainer,
    MatDrawer,
    MatList,
    MatListItem,
    MatDrawerContent,
    MatCard,
    MatCardHeader,
    MatCardTitle,
    MatCardContent,
    MatDivider,
    MatFormField,
    MatLabel,
    MatInputModule,
    MatCardActions,
    ReactiveFormsModule,
    MatTableModule,
    MatPaginator,
    MatSortHeader,
    MatSort,
    MatDatepickerInput,
    MatDatepickerToggle,
    MatDatepicker,
    MatNativeDateModule,
    MatSelect,
    MatOption],
  exports: [
    LoginComponent
  ],
  providers: [
    provideClientHydration(),
    provideAnimationsAsync(),
    authGuard,
    authorizationGuardGuard,
    provideHttpClient(withInterceptorsFromDi())
  ]
})
export class AppModule { }
