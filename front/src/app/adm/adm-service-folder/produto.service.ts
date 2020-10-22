
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

  public getAll(){
    return this.httpClient.get(this.url);
  }

  public getOne(id:number){
    return this.httpClient.get(`${this.url}/id`);
  }

  public update(id:number, dados){
    return this.httpClient.patch(`${this.url}/id`,dados);
  }

  public delete(id:number){
    this.httpClient.delete(`${this.url}/id`);
  }

  public save(produto){
    return this.httpClient.post(`${this.url}`, produto);
  }



}
