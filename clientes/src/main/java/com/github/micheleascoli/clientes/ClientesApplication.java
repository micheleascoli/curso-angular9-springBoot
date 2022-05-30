package com.github.micheleascoli.clientes;

import com.github.micheleascoli.clientes.model.entity.Cliente;
import com.github.micheleascoli.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

    public static void main(String[] args) {  //psvm
        SpringApplication.run(ClientesApplication.class, args);
    }
}
