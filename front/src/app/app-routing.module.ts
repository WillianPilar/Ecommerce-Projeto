import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GuardsService } from './adm/guards/guards.service';
import { EnderecoModule } from './adm/usuarios/endereco/endereco.module';

const routes : Routes = [
  {path : 'adm', loadChildren : ()=> import('./adm/adm.module').then(m=> m.AdmModule ), canActivate:[GuardsService]},
  {path : 'login', loadChildren : ()=> import('./adm/usuarios/login/login.module').then(m=> m.LoginModule )},
  {path : 'cadastro', loadChildren : ()=> import('./adm/usuarios/cadastro/cadastro.module').then(m=> m.CadastroModule)},
  {path : 'endereco', loadChildren : ()=> import('./adm/usuarios/endereco/endereco.module').then(m=> m.EnderecoModule)}
];
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)

  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
