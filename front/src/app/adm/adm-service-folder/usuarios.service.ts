import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private httpClient:HttpClient) { }

  public consultarUsuarios(){
    return this.httpClient.get("http://localhost:8081/usuarios");
  }
}
