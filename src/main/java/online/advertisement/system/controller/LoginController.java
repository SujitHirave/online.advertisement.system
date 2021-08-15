package online.advertisement.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.AppUserService;

/**
 * 
 * 
 * Controller for Registration, Login and Logout functionalities
 *
 */

@RestController()
@CrossOrigin(origins = "http://localhost:3005")

public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private AppUserService userService;

//	Registration for Admin and User
	@PostMapping("/Registration")
	public AppUser registerUser(@RequestBody AppUser users) {
		LOG.info("Registered Successfully");
		return userService.registerUser(users);
	}

//  Login for Admin and User
	@PostMapping("/login")
	public AppUser login(@RequestBody AppUser appUser) {
		LOG.info("loginController");
		LOG.info(appUser.getEmail());
		LOG.info(appUser.getPassword());
		AppUser appUser2 = userService.login(appUser);
		if ((appUser.getEmail().equals(appUser2.getEmail())
				&& (appUser.getPassword().equals(appUser2.getPassword())))) {
			return appUser2;
		} 
		return null;
	}

// Logout
	@GetMapping("/logout")
	public String logout() {
		LOG.info("logout");
		return userService.logout();
	}

}