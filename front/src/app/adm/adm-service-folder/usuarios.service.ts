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

  public consultarUsuarioId(id:Number){
    return this.httpClient.get(`http://localhost:8081/usuarios/${id}`);
  }

  public cadastrarUsuario(body){
    return this.httpClient.post("http://localhost:8081/usuarios",body);
  }

  public alterarUsuario(id:Number,body:any){
    return this.httpClient.patch(`http://localhost:8081/usuarios/${id}`,body);
  }

  public deletarUsuario(id:number){
    return this.httpClient.delete(`http://localhost:8081/usuarios/${id}`);
  }


}
