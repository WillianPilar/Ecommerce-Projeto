import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {  HttpClientModule } from '@angular/common/http';
import { MostrarErrosComponent } from './components/mostrar-erros/mostrar-erros.component';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
@NgModule({
  declarations: [MostrarErrosComponent],
  imports: [
    CommonModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    RouterModule

  ],
  exports:[MostrarErrosComponent,ToastrModule, FormsModule, ReactiveFormsModule, HttpClientModule, RouterModule]
})
export class SharedModule { }
