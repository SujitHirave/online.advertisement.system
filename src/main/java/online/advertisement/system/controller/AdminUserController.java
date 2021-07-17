package online.advertisement.system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import online.advertisement.system.model.AppUser;

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
import online.advertisement.system.service.AppUserService;
import online.advertisement.system.service.AdminUserService;
//impo

@RestController
public class AdminUserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(AdminUserController.class);
	
	@Autowired
	private AdminUserService service;
	
	@Autowired
	AppUserService appUserService;
	
//	View user details
	@GetMapping("/admin/getAllUserDetails")
	public List<AppUser> getAllUserDetails(){
		LOG.info("ViewUsers");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.getAllUsers();
		return null;
		
	}
	
////	View user list
//	@GetMapping("/admin/getUserList")
//	public List<AppUser> getUserList(){
//		LOG.info("ViewUserList");
//		if (appUserService.loginStatus().getRole().toString().equals("USER"))
//			return service.getUsersList();
//		return null;
//		
//	}
	
	
	

//	edit user
	@PutMapping("/admin/edit_user")
	public AppUser editUser(@RequestBody AppUser edit) {
		LOG.info("updateUser");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.editUserProfile(edit);
		return null;
		
	}
	
//	Delete User
	@DeleteMapping("/admin/deleteUser/{userid}")
	public  void deleteUser(@PathVariable int userid) {
		LOG.info("deleteUser-controller");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
		    service.deleteUser(userid);
		
	}
	

}