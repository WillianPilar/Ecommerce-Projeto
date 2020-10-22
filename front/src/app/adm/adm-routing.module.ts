import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsuariosComponent } from './usuarios/usuarios.component';
import { CategoriaListComponent } from './categoria/categoria-list/categoria-list.component';
import { CategoriaFormComponent } from './categoria/categoria-form/categoria-form.component';

const routes: Routes = [
  {path:"/usuarios",component:UsuariosComponent},
  { path: 'categoria' , component : CategoriaListComponent },
  { path : 'categoria/form', component : CategoriaFormComponent },
  { path : 'categoria/form/:id' , component : CategoriaFormComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdmRoutingModule { }
