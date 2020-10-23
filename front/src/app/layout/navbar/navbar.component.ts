import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CategoriaService } from 'src/app/adm/adm-service-folder/categoria.service';
import { AuthInterceptorsService } from 'src/app/shared/interceptors/auth-interceptors.service';
import { Categoria } from 'src/app/shared/models/categoria';
import { AuthService } from 'src/app/shared/services/auth.service';
import { StorageService } from 'src/app/shared/services/storage.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  public paginacao: Categoria;
  public isAuthenticated = false;

  constructor(
    private categoriasService: CategoriaService,
    private storageService: StorageService,
    private router: Router,
    private authService: AuthService
  ) { }

  ngOnInit(): void {
    //this.getAllAlunos();
     this.isAuthenticated = this.storageService.getLocalUser() ? true : false;

    this.authService.authSubject.subscribe(
      (message) => { this.isAuthenticated = message }
    );

    if (!this.isAuthenticated) {
      this.storageService.setLocalUser(null);
      this.router.navigate(['/login']);

    }
  }

  logout() {
    this.storageService.setLocalUser(null);
    this.router.navigate(['/login']);
  }
}
