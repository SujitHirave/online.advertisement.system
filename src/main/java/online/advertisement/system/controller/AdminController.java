package online.advertisement.system.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import online.advertisement.system.model.AppUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.service.AppUserService;
import online.advertisement.system.service.AdminService;

/**
 * 
 * controller for Admin functionalities
 *
 */

@RestController
public class AdminController {

	private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminService service;

	@Autowired
	AppUserService appUserService;

//  View Details of User
	@GetMapping("/admin/getAllUserDetails")
	public List<AppUser> getAllUserDetails() {
		LOG.info("ViewUsers");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.getAllUsers();
		return null;
	}

//	View list of Users
	@GetMapping("/admin/getUserList")
	public List<String> getUserList() {
		LOG.info("ViewUserList");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.getUsersList();
		return null;
	}

//	Edit 
	@PutMapping("/admin/edit_user")
	public AppUser editUser(@RequestBody AppUser edit) {
		LOG.info("updateUser");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.editUserProfile(edit);
		return null;
	}

//	Delete User
	@DeleteMapping("/admin/deleteUser/{userid}")
	public void deleteUser(@PathVariable int userid) {
		LOG.info("deleteUser-controller");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			service.deleteUser(userid);
	}

}