import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { VendasRoutingModule } from './vendas-routing.module';
import { CarrinhoComponent } from './carrinho/carrinho.component';


@NgModule({
  declarations: [CarrinhoComponent],
  imports: [
    CommonModule,
    VendasRoutingModule
  ]
})
export class VendasModule { }
