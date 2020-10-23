import { ProdutoService } from './../adm-service-folder/produto.service';
import { Component, Input, OnInit } from '@angular/core';
import { CategoriaService } from '../adm-service-folder/categoria.service';
import { CarouselConfig } from 'ngx-bootstrap/carousel';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [
    { provide: CarouselConfig, useValue: { interval: 0, noPause: true, showIndicators: true } }
  ]
})
export class HomeComponent implements OnInit {
  public produtosApi: any = [];
  public produtosApiBackup: any = [];
  public categoriasDaBox: any = [];

  @Input() slides ;
  constructor(
    private produtosService: ProdutoService,
    private categoriaService: CategoriaService,
   // private storageService: StorageService
  ) {
  }

  ngOnInit(): void {
    this.getAllProdutos();
    this.getCategorias();
    if(this.slides == null || this.slides == undefined || this.slides == ""){
      this.slides= [
         {image: 'assets/images/peomo.png'},
         {image: 'assets/images/pic2.jpg'},
         {image: 'assets/images/pic3.png'},
       ];
  }
}

  public getCategorias() {
    this.categoriaService.getAllCategorias()
      .subscribe(
        (resultado) => {
          console.log(resultado);
          this.categoriasDaBox = resultado;
        }
      );
  }

  public getAllProdutos() {
    this.produtosService.getAll()
      .subscribe(
        (resultado) => {
          console.log(resultado);
          this.produtosApi = resultado;
          this.produtosApiBackup = resultado;
        }
      );
  }

  public procurarProduto(id: number) {
    let produtos = [];
    this.produtosApiBackup.forEach(element => {
      if (element.categoria.id == id) {
        console.log(element.categoria.id)
        produtos.push(element);
      }
    });
    console.log("Depois " + produtos)
    this.produtosApi = produtos;
    console.log(id)
  }

  // inserirNoCarrinho(produto) {
  //   let itemVenda : ItemVenda = { produto : produto, quantidade : 1 , id: null };
  //   let carrinho : ItemVenda[] = this.storageService.getCarrinho();

  //   if (carrinho == null){
  //     carrinho = [];
  //   }
  //   console.log(carrinho)
  //   let index = carrinho.findIndex( x => { return x.produto.id == produto.id });
  //   console.log(index);
  //   if (index >= 0){
  //     carrinho[index].quantidade++;
  //   }
  //   else {
  //     carrinho.push(itemVenda);
  //   }

  //   this.storageService.setCarrinho(carrinho);
  // }

  // public finalizarVenda() {
  //   let venda : VendasModel = {
  //     id:null,
  //     usuario: this.storageService.getLocalUser(),
  //     statusVenda: 'Aberta',
  //     pagamento : '2',
  //     totalItens: this.storageService.getCarrinho().length,
  //     valor : this.storageService.getValorTotal(),
  //     parcela : 1,
  //     valorParcela : this.storageService.getValorTotal(),
  //     item: this.storageService.getCarrinho(),
  //     dataVenda : moment(new Date() ).format("DD-MM-yyyy HH:mm:ss")
  //   };
  // }


}
