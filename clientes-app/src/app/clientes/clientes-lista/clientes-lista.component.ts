import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ClientesService } from 'src/app/clientes.service';
import { Cliente } from '../cliente';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {

  clientes: Cliente[] = [];
  clienteSelecionado: Cliente;
  menssagemSucesso: string;
  menssagemError: string;


  constructor(
    private service: ClientesService, 
    private router: Router) {}

  ngOnInit(): void {
    this.service.getCliente()
      .subscribe( resposta => this.clientes = resposta);
  }

  novoCadastro(){
    this.router.navigate(['/clientes/form']);
  }

  preparaDelecao(cliente: Cliente){
    this.clienteSelecionado = cliente;
  }

  deletarCliente(){
    this.service
      .deletar(this.clienteSelecionado)
      .subscribe( 
        response => {
            this.menssagemSucesso = 'Cliente deletado com sucesso!'
            this.ngOnInit();  
          },
        erro => this.menssagemError = 'Ocorreu um erro ao deletar o cliente.')
    
      
  }

}
