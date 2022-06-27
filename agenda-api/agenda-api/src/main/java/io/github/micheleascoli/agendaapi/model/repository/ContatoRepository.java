package io.github.micheleascoli.agendaapi.model.repository;

import io.github.micheleascoli.agendaapi.model.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<Contato, Integer> {
}
