package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repo.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
@Repository
public class CustomJovin implements CustomRepo {

@Autowired
private EntityManager entityManager;
    @Override
    public List<UserEntity> findByEmailAndPassword(String email, String password) {

        List<UserEntity> r=entityManager.createQuery("from UserEntity where email=:email and password=:password")
                .setParameter("email",email)
                .setParameter("password",password).getResultList();
        return(r);
    }
    
    @Override
    public List<UserEntity> findById(int id)
    {
    	List<UserEntity> r=entityManager.createQuery("from UserEntity where id=:ID")
    			.setParameter("ID", id).getResultList();
		return (r);
    	
    }
}
