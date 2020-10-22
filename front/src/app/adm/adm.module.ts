import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdmRoutingModule } from './adm-routing.module';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { SharedModule } from '../shared/shared.module';


@NgModule({
  declarations: [UsuariosComponent],
  imports: [
    CommonModule,
    AdmRoutingModule,
    SharedModule
  ]
})
export class AdmModule { }
