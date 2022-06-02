package com.github.micheleascoli.clientes.rest;

import com.github.micheleascoli.clientes.model.entity.Cliente;
import com.github.micheleascoli.clientes.model.entity.ServicoPrestado;
import com.github.micheleascoli.clientes.model.repository.ClienteRepository;
import com.github.micheleascoli.clientes.model.repository.ServicoPrestadoRepository;
import com.github.micheleascoli.clientes.rest.dto.ServicoPrestadoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;

    public ServicoPrestadoController(ClienteRepository clienteRepository, ServicoPrestadoRepository servicoPrestadoRepository) {
        this.clienteRepository = clienteRepository;
        this.servicoPrestadoRepository = servicoPrestadoRepository;
    }


    @PostMapping
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/mm/yyyy"));
        Integer idCliente = dto.getIdCliente();
        
        Optional<Cliente> clienteOptional =  clienteRepository.findById(idCliente);


        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);


    }

}
