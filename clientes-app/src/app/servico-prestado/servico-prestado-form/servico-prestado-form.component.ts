import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../../clientes.service';
import { Cliente } from '../../clientes/cliente';
import { ServicoPrestado } from '../servicoPrestado';
import { ServicoPrestadoService } from '../../servico-prestado.service';
 

@Component({
  selector: 'app-servico-prestado-form',
  templateUrl: './servico-prestado-form.component.html',
  styleUrls: ['./servico-prestado-form.component.css']
})
export class ServicoPrestadoFormComponent implements OnInit {

  clientes: Cliente[] = [];
  servico: ServicoPrestado;
  success: boolean = false;
  errors: String[];


  constructor(
    private clienteService: ClientesService,
    private service: ServicoPrestadoService) {
    this.servico = new ServicoPrestado();
  }

  ngOnInit(): void {
    this.clienteService
    .getCliente()
    .subscribe( response => this.clientes = response);
  }
  
  onSubmit(){
    this.service
    .salvar(this.servico)
      .subscribe(response => {
        this.success = true;
        this.errors = [];
        this.servico = new ServicoPrestado();
      }, errorResponse => {
        this.errors = errorResponse.error.errors;
        this.success = false;
      })
  }

}
