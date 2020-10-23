import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { UsuarioPagination } from 'src/app/shared/models/usuario-pagination';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  public authSubject = new Subject<boolean>();

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

  //LOGIN
  public logar(body:any){
    return this.httpClient.post('http://localhost:8081/autenticacao',body);
  }

  public sendMessage(msg:boolean){
    this.authSubject.next(msg);
  }

  //Paginação
  public paginationLike(pagina: number, linhas: number, nome: string){
    return this.httpClient.get<UsuarioPagination>(`http://localhost:8081/usuarios/paginadorLike?pagina=${pagina}&linhas=${linhas}&nome=${nome}`);
  }


}
