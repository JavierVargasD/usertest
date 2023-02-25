package com.techtest.api.infrastructure.persistence;

import com.techtest.api.domain.TUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface UserRepository extends CrudRepository<TUser, String> {

    @Override
    List<TUser> findAll();

}
