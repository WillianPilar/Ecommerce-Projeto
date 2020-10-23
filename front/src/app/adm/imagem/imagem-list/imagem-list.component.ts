import { Component, OnInit } from '@angular/core';
import { ImagemService } from '../../adm-service-folder/imagem.service';

@Component({
  selector: 'app-imagem-list',
  templateUrl: './imagem-list.component.html',
  styleUrls: ['./imagem-list.component.css']
})
export class ImagemListComponent implements OnInit {

  public imagens : any;

  constructor(private imagemService : ImagemService) { }

  ngOnInit(): void {
    this.getAll();

  }

  getAll(){
    this.imagemService.getAll().subscribe(
      (dados) =>{
        this.imagens = dados;
      })
  }

  deletarImagem(id){
    this.imagemService.delete(id).subscribe(
      (dados)=> {
        console.log("teoricamente excluido");
        this.getAll();
      }
    )
  }



}
