package com.contass.lista_tarefas.repository;

import com.contass.lista_tarefas.model.ListaTarefas;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository da lista de tarefas
 * extendendo o CrudRepository
 * */
public interface ListaTarefaRepository extends CrudRepository<ListaTarefas, String> {
    ListaTarefas findByCodigo(long codigo);
}
