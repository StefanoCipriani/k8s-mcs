package com.k8s.mcs.user.repo.jpa;

import org.springframework.data.repository.CrudRepository;

import com.k8s.mcs.user.repo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
