import { CategoriaListComponent } from './categoria/categoria-list/categoria-list.component';
import { CategoriaFormComponent } from './categoria/categoria-form/categoria-form.component';

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmRoutingModule } from './adm-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoFormComponent } from './produto/produto-form/produto-form.component';
import { ProdutoListComponent } from './produto/produto-list/produto-list.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [CategoriaFormComponent, CategoriaListComponent],
  imports: [
    CommonModule,
    AdmRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    NgxPaginationModule,
    ToastrModule.forRoot(),
    RouterModule
  ]
})
export class AdmModule { }
