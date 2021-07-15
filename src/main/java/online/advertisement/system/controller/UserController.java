package online.advertisement.system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.UserService;

//import com.cg.spring.boot.demo.model.User;//
//import com.cg.spring.boot.demo.service.UserService;


@RestController("/user")
public class UserController {

	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService service;

//	user registration
	@PostMapping("/register") 
	public AppUser registerUser(@RequestBody AppUser users) {
		LOG.info("user");
		return service.registerUser(users);	
	}
//	edit user
	@PutMapping("/user/edit_user")
	public AppUser editUser(@RequestBody AppUser edit) {
		LOG.info("updateUser");
		return service.editUserProfile(edit);
	}
	
//	View user details
	@GetMapping("/admin/getAllUser")
	public List<AppUser> getAllUser(){
		LOG.info("ViewUsers");
		return service.getAllUsers();
	}
	
//	View user list
	@GetMapping("/admin/getUserList")
	public List<AppUser> getUserList(@RequestParam List<AppUser> username){
		LOG.info("ViewUserList");
		return service.getUsersList(username);
	}
	
//	Delete User
	@DeleteMapping("/admin/deleteuser/{userid}")
	public void deleteUser(@PathVariable int userid) {
		LOG.info("deleteUser-controller");
		service.deleteAdvertise(userid);
	}
	
	
//	@GetMapping("/getAdvByName/{advertisetitle}")
//	private List<Advertise> getAdvertise(@PathVariable("advertisetitle") String advertisetitle) {
//		return service.getAdvertiseByName(advertisetitle);
//	}
}
