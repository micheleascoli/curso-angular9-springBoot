import { Component, OnInit } from '@angular/core';
import { ContatoService } from '../contato.service';
import { Contato } from './contato';
import { FormBuilder, FormGroup, RequiredValidator, Validators } from '@angular/forms';

@Component({
  selector: 'app-contato',
  templateUrl: './contato.component.html',
  styleUrls: ['./contato.component.css']
})
export class ContatoComponent implements OnInit {

  formulario!: FormGroup;


  constructor(
    private service: ContatoService,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.formulario = this.fb.group({
      nome: ['', Validators.required],
      email: ['', [Validators.required, Validators.email] ]
    })
  }

  submit(){
    
    const erroNomeRequired = this.formulario.get('nome')?.errors?.['required'];
    const erroEmailRequired =this.formulario.get('email')?.errors?.['required'];
    const erroEmailInvalido =this.formulario.get('email')?.errors?.['email'];


    console.log('erroNomeRequired ', erroNomeRequired)
    console.log('erroEmailRequired ', erroEmailRequired)
    console.log('erroEmailInvalido ', erroEmailInvalido)
  }

}
