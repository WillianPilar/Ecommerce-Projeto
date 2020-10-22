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
  public noti: number = 0;
  isEdicao: boolean = false;
  idAluno: number = 0;
  textoBotao: string = 'Salvar';

  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private toastr: ToastrService, private usuariosService:UsuariosService) {
    this.formUsuarios = this.formBuilder.group({
      //valor inicial e os validadores
      id: ['', []],
      nome: ['', [Validators.required]],
      email: ['', [Validators.required]],
      senha: ['', [Validators.required]]
    });
  }

  ngOnInit(): void {
    this.activatedRoute
      .params.subscribe(
        (parametros) => {
          console.log(parametros);

          // if (parametros.id){
          //   this.isEdicao = true;
          //   this.idAluno = parametros.id;
          //   this.getOneAluno(parametros.id);
          //   this.textoBotao = 'Editar';
          // }
        }

      )
  }

  // onSubmit(){

  //   if(this.isEdicao){
  //     this.updateAluno(this.idAluno, this.meuForm.value);
  //   }
  //   else{
  //     this.createAluno(this.meuForm.value);
  //   }
  // }

  public cadastrarUsuario() {
    this.usuariosService.cadastrarUsuario(this.formUsuarios.value).subscribe(
      (response)=>{
        console.log(response);
      }
    );
        }


  public onSubmit() {
    this.cadastrarUsuario();
  }


  // MÉTODO DO MOSTRAR ERRO
  public isErrorField(fieldName) {
    return (this.formUsuarios.get(fieldName).valid == false && this.formUsuarios.get(fieldName).touched == true);
  }
}
