import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { ImagemService } from '../../adm-service-folder/imagem.service';

@Component({
  selector: 'app-imagem-form',
  templateUrl: './imagem-form.component.html',
  styleUrls: ['./imagem-form.component.css']
})
export class ImagemFormComponent implements OnInit {
  public imagemForm : FormGroup;
  public isEdicao : boolean = false;
  public idImagem : any;
  constructor(private formBuilder : FormBuilder, private imagemService : ImagemService, private activedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.pegarCampos();
  }

  pegarCampos(){
    this.imagemForm = this.formBuilder.group({
      url : ['', [Validators.required]]
      });
  }
  cadastrarImagem(){
    this.imagemService.save(this.imagemForm.value).subscribe( (dados) => {
      console.log(dados);
    }, (error) => {
      console.log(error);
    });
  }

  verificarEdicao(){
    this.activedRoute.params
      .subscribe((parametros)=>{

        if(parametros.id){
          this.isEdicao =true;
          this.idImagem = parametros.id;
          this.pegarUmaImagemEPopularNoForm(parametros.id);
        }

    });
  }

  private pegarUmaImagemEPopularNoForm(id){
    // this.imagemService.getOne(id).subscribe(
    //   (dados)=>{
    //     this.imagemForm.patchValue(dados)
    //    }
    //  )
 }
}
