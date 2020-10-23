import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../../adm-service-folder/produto.service';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {

  public produtoForm : FormGroup;
  public idProduto : number =0;
  public isEdicao : boolean =false;
  public textoBotao : string = 'Salvar';

  constructor(

    private formBuilder : FormBuilder,
    private produtoService : ProdutoService,
    private activedRoute : ActivatedRoute,
    private router : Router

  ) {

    this.produtoForm = this.formBuilder.group({
      nome : ['', [Validators.required]],
      descricao : ['', [Validators.required]],
      preco : ['', [Validators.required]],
      categoria :  this.formBuilder.group (
        {
          id : ['', [ ] ] ,
          nome : [ '', [ ] ]
        } ),
      imagens: ['',[]]
      })
   }

   ngOnInit(): void {

    this.activedRoute.params
      .subscribe((parametros)=>{

        if(parametros.id){
          this.isEdicao =true;
          this.idProduto =parametros.id;
          this.textoBotao ='Editar';
          this.getOne(parametros.id);
        }
        
    });

  }

  EnviarProduto(){

    if(this.isEdicao){
      console.log(this.produtoForm.value);
      this.update(this.idProduto, this.produtoForm.value);

    }
    else{
      console.log(this.produtoForm.value)
      this.save(this.produtoForm.value);
    }

  }

  private getOne(id){
     this.produtoService.getOne(id).subscribe(
       (dados)=>{

         this.produtoForm.patchValue(dados)
        }
      )
  }

  private update(id,produto){
    this.produtoService.update(id,produto).subscribe(
      (dados)=>{
        //alert('Atualizado com Sucesso');
        this.router.navigate(['/adm/produto/list']);
    })
  }

  private save(produto){
    this.produtoService.save(produto).subscribe(
      (resultado)=>{
        this.router.navigate(['/adm/produto/list']);

    });
  }




}
