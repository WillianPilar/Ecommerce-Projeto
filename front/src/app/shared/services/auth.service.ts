import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  url = `${environment.urlApi}/autenticacao`;
  public authSubject = new Subject<boolean>();

  constructor(private httpClient: HttpClient) { }

  public autenticacao(login: any) {
     return this.httpClient.post(this.url, login);
  }

  public sendMessage(msg: boolean) {
    this.authSubject.next(msg);
  }
}
