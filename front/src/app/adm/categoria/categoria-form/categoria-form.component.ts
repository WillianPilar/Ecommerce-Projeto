import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../../adm-service-folder/categoria.service';

@Component({
  selector: 'app-categoria-form',
  templateUrl: './categoria-form.component.html',
  styleUrls: ['./categoria-form.component.css']
})
export class CategoriaFormComponent implements OnInit {

  constructor(private categoriaService : CategoriaService) { }

  ngOnInit(): void {
  }

}
