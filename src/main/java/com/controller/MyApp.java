package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.UserService;

import com.model.*;

@Controller
@RequestMapping("/myapp")
public class MyApp {

	@Autowired
	UserService us;

	@PostMapping("/login")
	public String loginValid(@RequestParam("uname") String name, @RequestParam("pass") String pass, ModelMap map) {
		if (us.loginValid(name, pass)) {
			return "success";
		}
		map.put("errorMessage", "Login Failed");
		return "login";

	}

	@PostMapping("/register")
	public String store(@RequestParam("uname") String name, @RequestParam("upass") String pass,
			@RequestParam("uemail") String email, @RequestParam("ucity") String city) {

		if (us.registration(name, pass, email, city)) {
			return "register_success";
		}
		return "Register Failure";
	}

	@GetMapping("/findAll")
	@ResponseBody
	public List<User> loadAll() {
		return us.loadUsers();
	}

	@GetMapping("/finduser/{name}")
	@ResponseBody
	public String findUSer(@PathVariable("name") String name) {

		if (us.findUser(name)) {
			return "User found";
		}
		return "User not found";
	}

	@GetMapping("/deleteuser/{name}")
	@ResponseBody
	public String deleteUSer(@PathVariable("name") String name) {

		if (us.deleteUser(name)) {
			return "User has deleted";
		}
		return "User not found";
	}

	@GetMapping("/updateuser/{uname}/{pass}/{email}/{city}")
	public String updateUser(@PathVariable("uname") String name, @PathVariable("pass") String pass,
			@PathVariable("email") String email, @PathVariable("city") String city) {
		us.updateUser(name, pass, email, city);
		return "user updated successfully";
	}

}
