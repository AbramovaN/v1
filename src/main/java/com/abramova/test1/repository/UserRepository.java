package com.abramova.test1.repository;

import com.abramova.test1.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

}
