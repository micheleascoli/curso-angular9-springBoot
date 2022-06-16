package com.github.micheleascoli.clientes.rest;

import com.github.micheleascoli.clientes.exception.UsuarioCadastradoException;
import com.github.micheleascoli.clientes.model.entity.Usuario;
import com.github.micheleascoli.clientes.model.repository.UsuarioRepository;
import com.github.micheleascoli.clientes.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar( @RequestBody @Valid Usuario usuario ){
        try{
            usuarioService.salvar(usuario);
        }catch (UsuarioCadastradoException e){
            throw  new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }

    }

}
