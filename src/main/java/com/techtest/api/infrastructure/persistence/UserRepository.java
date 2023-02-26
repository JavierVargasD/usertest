package com.techtest.api.infrastructure.persistence;

import com.techtest.api.domain.entity.TUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface UserRepository extends CrudRepository<TUser, String> {

    @Override
    List<TUser> findAll();

    List<TUser> findByEmail(String email);

}
