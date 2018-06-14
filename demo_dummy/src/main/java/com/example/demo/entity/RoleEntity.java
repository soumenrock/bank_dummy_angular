package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="role")
public class RoleEntity {
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", length=100)
	private int id;
	@Column(name="password",length=40)
	private String password;
	
	@OneToMany(mappedBy="role")
	private  Set<UserEntity> ue=new HashSet<UserEntity>();
	public Set<UserEntity> getUe() {
		return ue;
	}
	public void setUe(Set<UserEntity> ue) {
		this.ue = ue;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
