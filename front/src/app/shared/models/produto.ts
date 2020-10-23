import { Categoria } from './categoria';

export class Produto {
  id:number;
  nome:string;
  preco:number;
  descricao:string;
  categoria:Categoria[] = [];
  imagem:any;

}
