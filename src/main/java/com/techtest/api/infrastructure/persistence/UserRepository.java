package com.prueba.api.infrastructure.persistence;

import com.prueba.api.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface UserRepository extends CrudRepository<User, String> {

    @Override
    List<User> findAll();

}
