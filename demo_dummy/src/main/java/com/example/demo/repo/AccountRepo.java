package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Accounts;

public interface AccountRepo extends CrudRepository<Accounts, Integer>{
	
}
