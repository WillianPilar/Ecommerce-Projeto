import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmRoutingModule } from './adm-routing.module';
import { ProdutoFormComponent } from './produto/produto-form/produto-form.component';
import { ProdutoListComponent } from './produto/produto-list/produto-list.component';
import { RouterModule } from '@angular/router';


@NgModule({
  declarations: [ProdutoFormComponent, ProdutoListComponent],
  imports: [
    CommonModule,
    AdmRoutingModule,
    RouterModule
  ]
})
export class AdmModule { }
