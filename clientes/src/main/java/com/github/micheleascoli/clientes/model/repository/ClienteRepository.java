package com.github.micheleascoli.clientes.model.repository;

import com.github.micheleascoli.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
