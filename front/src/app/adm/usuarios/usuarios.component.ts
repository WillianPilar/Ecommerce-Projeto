import { Component, OnInit } from '@angular/core';
import { UsuariosService } from './usuarios.service';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  constructor(private usuarioService:UsuariosService) { }

  ngOnInit(): void {
    this.consultarUsuarios();
  }

  public consultarUsuarios(){
    this.usuarioService.consultarUsuarios().subscribe(
      (response)=>{
        console.log(response);
      }

    );
  }




}
