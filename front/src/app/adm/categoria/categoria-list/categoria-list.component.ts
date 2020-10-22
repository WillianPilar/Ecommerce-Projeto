import { Component, OnInit } from '@angular/core';
import {  ToastrService } from 'ngx-toastr';
import { CategoriaService } from '../../adm-service-folder/categoria.service';

@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
  styleUrls: ['./categoria-list.component.css']
})
export class CategoriaListComponent implements OnInit {

  public categoria : any =[]
  public nome : "";

  constructor(private categoriaService : CategoriaService) { }

  ngOnInit(): void {
    this.getAllCategorias();
  }

  public getAllCategorias(){
    this.categoriaService.getAllCategorias()
    .subscribe(
      (response) => {
        this.categoria = response;
        console.log(response);
      }
    )
  }

  public deletarCategoria(id : any){
    this.categoriaService.delete(id)
    .subscribe(
      (response) => {
        console.log(response);
        alert("categoria deletada com sucesso!");
        this.getAllCategorias();
        //this.toastr.success("categoria deletada com sucesso!")
      }
    )
  }


}
