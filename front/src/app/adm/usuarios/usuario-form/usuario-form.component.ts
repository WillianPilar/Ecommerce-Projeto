import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UsuariosService } from '../../adm-service-folder/usuarios.service';

@Component({
  selector: 'app-usuario-form',
  templateUrl: './usuario-form.component.html',
  styleUrls: ['./usuario-form.component.css']
})
export class UsuarioFormComponent implements OnInit {
  formUsuarios: FormGroup;
  idUsuario: number = 0;
  isEdicao: boolean = false;
  exibir: boolean = false;
  texto: string = "Cadastrar";
  textoBotao: string = 'Salvar';


  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService, private usuariosService: UsuariosService) {
    this.formUsuarios = this.formBuilder.group({
      //valor inicial e os validadores
      id: ['', []],
      nome: ['', [Validators.required]],
      email: ['', [Validators.required]],
      senha: ['', [Validators.required]],
      perfis: ['',[ ]]
    });
  }

  ngOnInit(): void {
    this.activatedRoute
      .params.subscribe(
        (parametros) => {
          console.log(parametros);
          if (parametros.id) {
            this.isEdicao = true;
            this.idUsuario = parametros.id;
            this.consultarUsuarioId(this.idUsuario);
            this.textoBotao = 'Editar';
            this.texto = "Alterar";
          }
        }

      )
  }

  onSubmit() {

    if (this.isEdicao) {
       this.alterarUsuario(this.idUsuario, this.formUsuarios.value);
    }
    else {
      this.cadastrarUsuario(this.formUsuarios.value);
    }
  }


  public consultarUsuarioId(idUsuario) {
    this.usuariosService.consultarUsuarioId(idUsuario).subscribe(
      (response) => {
        this.formUsuarios.patchValue(response);
      }
    );
  }

  public cadastrarUsuario(body) {
    this.usuariosService.cadastrarUsuario(body).subscribe(
      (response) => {
        console.log(response);
        this.router.navigate(['adm/usuarios']);
      }
    );
  }

  private alterarUsuario(id,body){
    this.usuariosService.alterarUsuario(id, body)
    .subscribe(
      (dados) =>{
        console.log(dados);
        //this.toastr.success('Usuario Alterado com Sucesso!');
        this.router.navigate(['adm/usuarios']);
        // console.log(JSON.stringify(dados));
      }
    )
  }


  // MÉTODO DO MOSTRAR ERRO
  public isErrorField(fieldName) {
    return (this.formUsuarios.get(fieldName).valid == false && this.formUsuarios.get(fieldName).touched == true);
  }
}
