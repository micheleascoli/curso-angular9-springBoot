import{ Component } from '@angular/core'

@Component({
    selector: 'hello',
    templateUrl:'./hello.component.html'
})
export class HelloComponent {
    nome : string;
    clientes: Cliente[];

    constructor(){
        this.nome = 'Fulano';

        let fulano = new Cliente ('Fulano', 26);
        let beltrano = new Cliente('Beltrano', 58);

        this.clientes =[fulano, beltrano];

    }

}

class Cliente {
    constructor (
        public nome: string,
        public idade: number
    ){}
    
}