import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuariosService } from '../../adm-service-folder/usuarios.service';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {
  formCadastro: FormGroup;
  textoBotao: string = 'Salvar';
  texto: string = "Cadastrar";

   constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private usuariosService: UsuariosService) {

    this.formCadastro = this.formBuilder.group({
      //valor inicial e os validadores
      nome: ['', [Validators.required]],
      email: ['', [Validators.required]],
      senha: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
  }

  onSubmit(){
    let body  = Object.assign(this.formCadastro.value,{perfis:[2]});
    this.usuariosService.cadastrarUsuario(body).subscribe(
    (response) => {
      console.log(response);
    }
    );
  }


  // MÉTODO DO MOSTRAR ERRO
  public isErrorField(fieldName) {
    return (this.formCadastro.get(fieldName).valid == false && this.formCadastro.get(fieldName).touched == true);
  }
}
