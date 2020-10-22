import { Component, OnInit } from '@angular/core';
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
  }

  public getAllCategorias(){
    this.categoriaService.getAllCategorias()
    .subscribe(
      (response) => {
        console.log(response);
      }
    )
  }


}
