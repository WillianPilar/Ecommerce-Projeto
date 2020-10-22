import { CategoriaListComponent } from './categoria/categoria-list/categoria-list.component';
import { CategoriaFormComponent } from './categoria/categoria-form/categoria-form.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProdutoFormComponent } from './produto/produto-form/produto-form.component';
import { ProdutoListComponent } from './produto/produto-list/produto-list.component';

const routes: Routes = [
  {path : 'produto/form', component : ProdutoFormComponent},
  {path : 'produto/list', component : ProdutoListComponent},
  { path: 'categoria' , component : CategoriaListComponent },
  { path : 'categoria/form', component : CategoriaFormComponent },
  { path : 'categoria/form/:id' , component : CategoriaFormComponent },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmRoutingModule { }
