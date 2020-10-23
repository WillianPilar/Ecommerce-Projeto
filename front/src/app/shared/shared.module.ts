import { NgModule } from '@angular/core';
import {  HttpClientModule } from '@angular/common/http';
import { MostrarErrosComponent } from './components/mostrar-erros/mostrar-erros.component';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { CommonModule } from '@angular/common';
import { CarouselModule } from 'ngx-bootstrap/carousel';

@NgModule({
  declarations: [MostrarErrosComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    NgMultiSelectDropDownModule,
    CarouselModule.forRoot(),

  ],
  exports:[ MostrarErrosComponent,
            ToastrModule,
            FormsModule,
            ReactiveFormsModule,
            HttpClientModule,
            RouterModule,
            NgMultiSelectDropDownModule,
            CarouselModule
            ]
})
export class SharedModule { }
