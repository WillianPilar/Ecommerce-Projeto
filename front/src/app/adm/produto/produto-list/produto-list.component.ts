import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../adm-service-folder/produto.service';

@Component({
  selector: 'app-produto-list',
  templateUrl: './produto-list.component.html',
  styleUrls: ['./produto-list.component.css']
})
export class ProdutoListComponent implements OnInit {
  public listaDoProduto : any = [];
  constructor(private produtoService : ProdutoService) { }

  ngOnInit(): void {
    this.listaDoProduto();
  }

  ListarOsProduto(){
    this.produtoService.getAll().subscribe( (dadosPego) => {
      console.log(dadosPego);
      this.listaDoProduto = dadosPego;
    }, (error) =>{
      console.log(error);
    });
  }

 
  excluirProduto(prod){
    this.produtoService.delete(prod.id);
  }
}
