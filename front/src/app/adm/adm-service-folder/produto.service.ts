import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  url = `${environment.urlApi}/produto`;

  constructor(private httpClient:HttpClient) {

  }

  private getAll(){
    return this.httpClient.get(this.url);
  }

  private getOne(id:number){
    return this.httpClient.get(`${this.url}/id`);
  }

  private update(id:number, dados){
    return this.httpClient.patch(`${this.url}/id`,dados);
  }

  private delete(id:number){
    this.httpClient.delete(`${this.url}/id`);
  }

}
