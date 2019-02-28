package com.abramova.blog_cms.repository;

import com.abramova.blog_cms.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
