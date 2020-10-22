import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from '@angular/router';


const routes : Routes = [
  {path : 'adm', loadChildren : ()=> import('./adm/adm.module').then(m=> m.AdmModule )}  
];
@NgModule({
  //declarations: [],
  imports: [
    //CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
