import { Component, OnInit } from '@angular/core';
import { ItemVenda } from 'src/app/shared/models/Item-Venda';
import { StorageService } from 'src/app/shared/services/storage.service';
import { VendaService } from '../Venda-Services/venda.service';

@Component({
  selector: 'app-carrinho',
  templateUrl: './carrinho.component.html',
  styleUrls: ['./carrinho.component.css']
})
export class CarrinhoComponent implements OnInit {

  public carrinho: any = [];
  public valorTotal;
  public carrinhoNotnull = false;

  constructor(private storageService: StorageService,
    private vendaService: VendaService) { }

  ngOnInit(): void {
    this.getCarrinho();
    this.calculoDoTotal();
  }

  getCarrinho() {
    
    this.carrinho = this.storageService.getCarrinho();
    this.carrinhoNotnull = this.carrinho && this.carrinho.length>0;
    console.log(this.carrinho);
    console.log(this.carrinhoNotnull);
  }

  deletarDoCarrinho(produto) {
    let index = this.carrinho.findIndex(x => { return x.produto.id == produto.id });

    this.carrinho.splice(index, 1);

    this.storageService.setCarrinho(this.carrinho);
    this.calculoDoTotal();
    this.getCarrinho();
  }

  //--------------------------------------------------
  atualizarCarrinho(selectedOption, id) {
    let num = parseInt(selectedOption)
    //REVISão condição IF após conclusão
    if (num <= 0) {
      this.deletarDoCarrinho(id);
    }
    //-------------------------------------------------
    let find = this.carrinho.find((item: ItemVenda) => item.produto.id === id)

    if (find) {
      find.quantidade = num
    }

    console.log(this.carrinho);
    console.log(selectedOption);
    console.log(id);
    this.storageService.setCarrinho(this.carrinho);
    this.calculoDoTotal();
    this.getCarrinho();
  }

  calculoDoTotal() {

    if (this.carrinho) {
      this.valorTotal = this.carrinho.reduce((valorProdutos, item) => valorProdutos + (item.produto.preco * item.quantidade), 0)
    }
  }

  //------------------------------------------
  // Finalização da compra

  // finalizarCompra(){
  //   let venda:Vendas ={
  //     id:null,
  //     usuario:this.storageService.getLocalUser(),
  //     statusVenda : 'Aberta',
  //     pagamento : '2',
  //     totalItens: this.storageService.getCarrinho().length,
  //     valor : this.valorTotal,
  //     parcela :2,
  //     valorParcela : this.valorTotal/2,
  //     item:this.storageService.getCarrinho(),
  //     dataVenda : moment(new Date()).format("DD-MM-yyyy HH:mm:ss")
  //   }
  //   delete venda.usuario.perfis

  //   this.vendaService.finalizarCompra(venda).subscribe(
  //     (response)=>{
  //       console.log(response);
  //     }
  //   );


  //}



}
