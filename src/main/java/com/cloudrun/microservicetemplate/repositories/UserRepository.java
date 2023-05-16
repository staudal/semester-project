package com.cloudrun.microservicetemplate.repositories;

import com.cloudrun.microservicetemplate.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
