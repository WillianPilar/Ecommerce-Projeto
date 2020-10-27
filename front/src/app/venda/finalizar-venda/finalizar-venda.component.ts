import { Component, OnInit } from '@angular/core';
import { ItemVenda } from 'src/app/shared/models/Item-Venda';
import { StorageService } from 'src/app/shared/services/storage.service';
import { VendaService } from '../Venda-Services/venda.service';
import * as moment from 'moment';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UsuariosService } from 'src/app/adm/adm-service-folder/usuarios.service';
import { isThisTypeNode } from 'typescript';

@Component({
  selector: 'app-finalizar-venda',
  templateUrl: './finalizar-venda.component.html',
  styleUrls: ['./finalizar-venda.component.css']
})
export class FinalizarVendaComponent implements OnInit {

  public carrinho : any  = [];
  public valorTotal;
  public quant : any;
  public formaPagamento :any;
  public formEndereco : FormGroup;
  public formPagamento : FormGroup;
  public isCartao : boolean = false;
  public varPagamento : any = "";


  public idLocalUser = this.storageService.getLocalUser()?.id;
  public endereco = null;

  constructor(private storageService : StorageService,
              private vendaService : VendaService,
              private formBuilder : FormBuilder,
              private usuariosService : UsuariosService) {

        this.formEndereco = this.formBuilder.group(
        {
          logradouro : [''],
          numero : [''],
          cidade : [''],
          estado : [''],
          cep : ['']
        }
      );

        this.formPagamento = this.formBuilder.group(
          {
            metodo : ['']
          }
        );



  }

  ngOnInit(): void {

    console.log(this.storageService.getCarrinho());
    this.getCarrinho();
    this.calculoDoTotal();
    this.somarQuantProdutos();
    this.preencherInformacoes();
  }

  getCarrinho(){
    this.carrinho = this.storageService.getCarrinho();
  }

  deletarDoCarrinho(produto){
    let index = this.carrinho.findIndex( x => { return x.produto.id == produto.id });

    this.carrinho.splice(index, 1);

    this.storageService.setCarrinho(this.carrinho);

    this.calculoDoTotal();
  }

//--------------------------------------------------
  atualizarCarrinho(selectedOption, id){
    let num = parseInt(selectedOption)
    //REVISão condição IF após conclusão
    if(num <= 0){
      this.deletarDoCarrinho(id);
    }
//-------------------------------------------------
    let find = this.carrinho.find((item: ItemVenda) => item.produto.id === id)

    if (find) {
      find.quantidade = num
    }

    console.log(this.carrinho)
    console.log(selectedOption)
    console.log(id)
    this.storageService.setCarrinho(this.carrinho);
    this.calculoDoTotal();
  }

  calculoDoTotal(){

    this.valorTotal = this.carrinho.reduce((valorProdutos, item) => valorProdutos + (item.produto.preco * item.quantidade), 0)
  }

  public somarQuantProdutos() {
    let quantTotalArray= 0;
    this.carrinho.forEach(function (response) {
      quantTotalArray += response?.quantidade;
    });
    this.quant = quantTotalArray;
  }

  public preencherInformacoes() {
    this.usuariosService.consultarUsuarioId(this.idLocalUser).subscribe(
      (response: any) => {
        this.endereco = response?.endereco;
        if (this.endereco) {
          this.formEndereco.patchValue(this.endereco);
        }
        console.log(this.endereco);
      }
    );
  }

  formaPag(){
    alert(this.formPagamento.value.metodo)
  }


  onSubmit(){

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

  //   }


  }
