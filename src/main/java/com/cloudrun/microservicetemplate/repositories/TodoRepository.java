package com.cloudrun.microservicetemplate.repositories;

import com.cloudrun.microservicetemplate.entities.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface TodoRepository extends CrudRepository<Todo, UUID> {
}
