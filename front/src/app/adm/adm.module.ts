import { CategoriaListComponent } from './categoria/categoria-list/categoria-list.component';
import { CategoriaFormComponent } from './categoria/categoria-form/categoria-form.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdmRoutingModule } from './adm-routing.module';
import { SharedModule } from '../shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgxPaginationModule } from 'ngx-pagination';
import { ToastrModule, ToastrService } from 'ngx-toastr';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoFormComponent } from './produto/produto-form/produto-form.component';
import { ProdutoListComponent } from './produto/produto-list/produto-list.component';
import { RouterModule } from '@angular/router';
import { UsuariosComponent } from './usuarios/usuario-list/usuarios.component';
import { UsuarioFormComponent } from './usuarios/usuario-form/usuario-form.component';

@NgModule({
  declarations: [CategoriaFormComponent, CategoriaListComponent,ProdutoFormComponent,ProdutoListComponent,ProdutoListComponent,UsuariosComponent, UsuarioFormComponent],
  imports: [
    CommonModule,
    AdmRoutingModule,
    //RouterModule,
    //HttpClientModule,
    SharedModule,
    //NgxPaginationModule,
    
  ]
})
export class AdmModule { }
