package com.k8s.mcs.usersandorders.repo.jpa.user;

import org.springframework.data.repository.CrudRepository;

import com.k8s.mcs.usersandorders.repo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
