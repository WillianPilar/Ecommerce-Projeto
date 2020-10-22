import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
  styleUrls: ['./produto-form.component.css']
})
export class ProdutoFormComponent implements OnInit {
  public produtoForm : FormGroup;

  constructor(private formBuilder : FormBuilder) {
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
  }

  EnviarProduto(){

  }

}
