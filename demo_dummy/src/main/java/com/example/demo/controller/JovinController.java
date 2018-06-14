package com.example.demo.controller;

import com.example.demo.repo.AccountRepo;
import com.example.demo.repo.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Accounts;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserRepository;

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
	
	@Autowired
	public AccountRepo accRepo;
	
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
	@PostMapping("/fetchUser")
	public UserEntity userdetails(@RequestBody String id,HttpServletResponse response)
	{
		System.out.println("**********Inside fetchUser*********"+id);
		List<UserEntity> ud= customRepo.findById(Integer.parseInt(id));
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


	@PostMapping("/createAccount")
	public Accounts createAccount(@RequestBody Accounts acc, HttpServletResponse response)
	{
		System.out.println("******"+acc.getUserId());

		

		Accounts account=accRepo.save(acc);
		System.out.println(acc);
		return account;
		
	}
	
	@PostMapping("/fetchAccount")
	public Accounts fetchAccount(@RequestBody String uid,HttpServletResponse response)
	{
		System.out.println("**********Inside fetchAccount*********"+uid);
		List<Accounts> a= customRepo.findByUser(Integer.parseInt(uid));
		if(a.isEmpty()) {
			System.out.println("got nothing");
			


		}
		else
		{
		for (Accounts account : a) {
			System.out.println(account);
			return account;
		}
		}
		return null;
	}
	
}