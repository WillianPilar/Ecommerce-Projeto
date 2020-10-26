import { NgModule } from '@angular/core';
import {  HttpClientModule } from '@angular/common/http';
import { MostrarErrosComponent } from './components/mostrar-erros/mostrar-erros.component';
import { ToastrModule } from 'ngx-toastr';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgMultiSelectDropDownModule } from 'ng-multiselect-dropdown';
import { CommonModule } from '@angular/common';
import { PerfilPipe } from './pipes/perfil.pipe';

@NgModule({
  declarations: [MostrarErrosComponent, PerfilPipe],
  imports: [
    CommonModule,
    HttpClientModule,
    ToastrModule.forRoot(),
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    NgMultiSelectDropDownModule

  ],
  exports:[ MostrarErrosComponent,
            ToastrModule,
            FormsModule,
            ReactiveFormsModule,
            HttpClientModule,
            RouterModule,
            NgMultiSelectDropDownModule,
            PerfilPipe]
})
export class SharedModule { }
