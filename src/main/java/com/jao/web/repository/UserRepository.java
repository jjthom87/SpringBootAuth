package com.jao.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jao.web.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, String> {
	UserEntity findByUsername(String username);
	List<UserEntity> findAll();
}