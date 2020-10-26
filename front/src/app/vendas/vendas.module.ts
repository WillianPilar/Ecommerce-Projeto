import { VendasRoutingModule } from './vendas-routing.module';
import { HomeComponent } from './home/home.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from '../shared/shared.module';
import { NgxPaginationModule } from 'ngx-pagination';
import { RouterModule } from '@angular/router';
import { CarouselModule } from 'ngx-bootstrap/carousel';

@NgModule({
  declarations: [
    HomeComponent,
  ], imports: [
    SharedModule,
    CommonModule,
    VendasRoutingModule,
    NgxPaginationModule,
    RouterModule,
    CarouselModule.forRoot()]
})
export class VendasModule { }

