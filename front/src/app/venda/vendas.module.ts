import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VendasRoutingModule } from './vendas-routing.module';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { SharedModule } from '../shared/shared.module';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [CarrinhoComponent,HomeComponent],
  imports: [
    CommonModule,
    VendasRoutingModule,
    SharedModule
  ]
})
export class VendasModule { }
