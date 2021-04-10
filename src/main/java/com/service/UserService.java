package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;
import com.repo.MyRepo;

@Service
public class UserService {

	@Autowired
	private MyRepo myRepo;

	public ArrayList<User> al = new ArrayList<User>();

	public boolean loginValid(String name, String password) {
		if (name.equals("admin") && password.equals("manager")) {
			return true;
		}
		return false;
	}

	public boolean registration(String name, String password, String email, String city) {
//		al.add(new Data(name,email,password,city));
		myRepo.save(new User(name, email, password, city));
//		System.out.println(al);
		return true;
	}

	public List<User> loadUsers() {
		return (List<User>) myRepo.findAll();
	}

	public boolean findUser(String name) {
		Optional<User> user = myRepo.findById(name);

		if (user.isPresent()) {
			System.out.println(user);
			return true;
		}

		return false;
	}

	public Optional<User> getUser(String name) {
		return myRepo.findById(name);
	}

	public boolean updateUser(String name, String pass, String email, String city) {
		Optional<User> user = myRepo.findById(name);
		if (user.isPresent()) {
			myRepo.deleteById(name);
			myRepo.save(new User(name, pass, email, city));
			return true;
		}
		return false;
	}

	public boolean deleteUser(String name) {
		Optional<User> user = myRepo.findById(name);

		if (user.isPresent()) {
			myRepo.deleteById(name);
			System.out.println(user);
			return true;
		}

		return false;
	}

}
