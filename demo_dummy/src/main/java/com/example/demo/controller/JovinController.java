package com.example.demo.controller;

import com.example.demo.repo.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repo.UserRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/jovin")
public class JovinController {
	
	@Value("${hello.myMessage}")
	public String myMessage;
	
	@Autowired
	public UserRepository userRepo;
	@Autowired
	public CustomRepo customRepo;
	
	@GetMapping("/hello")
	public String hello()
	{
		return myMessage;
	}
	
	@PostMapping("/createUser")
	public UserEntity createUser(@RequestBody UserEntity user, HttpServletResponse response) {

//		UserEntity userEntity = new UserEntity();
//		userEntity.setId("11231231");
//		userEntity.setEmail("soumen123@gmail.com");
//		userEntity.setName("Soumen");
//		userEntity.setPassword("12345");
//		userEntity.setPhone("1234567890");
//
//		RoleEntity role = new RoleEntity();
//		role.setId("1234");
//		role.setPassword("asdasdasdasd");
//		userEntity.setRole(role);
//
//		//Save User entity
//		userRepo.save(userEntity);
		System.out.println("******"+user.getName());

		user.setRole(1);

		UserEntity userEntity=userRepo.save(user);
		System.out.println("Controller");
		return userEntity;
	}
	@PostMapping("/loginUser")
	public UserEntity userLogin(@RequestBody UserEntity user, HttpServletResponse response)
	{

		System.out.println(user.getEmail());
		List<UserEntity> ud= customRepo.findByEmailAndPassword(user.getEmail(),user.getPassword());
		//System.out.println(ud);
		if(ud.isEmpty()) {
			System.out.println("got nothing");
			


		}
		else
		{
			for (UserEntity userEntity : ud) {
				System.out.println(userEntity.getName());
				return(userEntity);
				
			}
			
			
			

		}

		return null;
	}
	
	public UserEntity userdetails(@RequestParam int id)
	{
		List<UserEntity> ud= customRepo.findById(id);
		for (UserEntity userEntity : ud) {
			System.out.println(userEntity.getName());
			return(userEntity);
		
	}


}
