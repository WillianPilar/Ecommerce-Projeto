import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class VendaService {

  constructor(private httpClient : HttpClient) { }

  public finalizarCompra(body){
    return this.httpClient.post(`http://localhost:8081/venda`, body);
  }

}
