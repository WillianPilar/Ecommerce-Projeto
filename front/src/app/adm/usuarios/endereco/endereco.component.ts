import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { UsuariosService } from '../../adm-service-folder/usuarios.service';
import { StorageService } from 'src/app/shared/services/storage.service';

@Component({
  selector: 'app-endereco',
  templateUrl: './endereco.component.html',
  styleUrls: ['./endereco.component.css']
})
export class EnderecoComponent implements OnInit {

  formEndereco: FormGroup;
  public idLocalUser = this.storageService.getLocalUser()?.id;

  constructor(private formBuilder: FormBuilder,
              private enderecoService: UsuariosService,
              private router: Router,
              private toastr: ToastrService,
              private activatedRoute: ActivatedRoute,
              private storageService : StorageService){}




  ngOnInit(): void {
    this.createForm();
  }


  private createForm(){
    this.formEndereco = this.formBuilder.group(
      {
       cep : [ '',[ Validators.required] ],
       estado : [""],
       cidade : [""],
       bairro: [""],
       logradouro : [""],
       numero : [""]
      },
    );
  }

  onSubmit() {
    let body  = Object.assign(this.formEndereco.value,{usuario:{id:this.idLocalUser}});
    this.enderecoService.cadastrarEndereco(body).subscribe(
      (response) => {
        console.log(response);
        this.toastr.success("Endereço linkado com sucesso");
      }, (error) => {
        console.log(error.status);
        alert("Erro ao cadastrar endereço!");
      }
    );
  }

  public buscarCEP() {

    this.enderecoService.buscarCEP(this.formEndereco.value.cep).subscribe(
      (response: any) => {
        console.log(response);
        this.formEndereco.patchValue({ estado: response.uf, bairro: response.bairro, cidade: response.localidade, logradouro: response.logradouro });
      }
    );
}


  isErrorField(fieldname) {
    return (this.formEndereco.get(fieldname).valid == false && this.formEndereco.get(fieldname).touched == true);
  }
}
