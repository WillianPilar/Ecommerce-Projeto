import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VendasRoutingModule } from './vendas-routing.module';
import { CarrinhoComponent } from './carrinho/carrinho.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [CarrinhoComponent],
  imports: [
    CommonModule,
    VendasRoutingModule,
    SharedModule
  ]
})
export class VendasModule { }
