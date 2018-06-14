package com.example.demo.repo;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.UserEntity;

import java.util.List;

public interface CustomRepo {
    List<UserEntity> findByEmailAndPassword(String email, String password);
    public List<UserEntity> findById(int id);
    public List<Accounts> findByUser(int uid);
}
