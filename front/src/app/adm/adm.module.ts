import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmRoutingModule } from './adm-routing.module';
import { ProdutoFormComponent } from './produto/produto-form/produto-form.component';
import { ProdutoListComponent } from './produto/produto-list/produto-list.component';


@NgModule({
  declarations: [ProdutoFormComponent, ProdutoListComponent],
  imports: [
    CommonModule,
    AdmRoutingModule
  ]
})
export class AdmModule { }
