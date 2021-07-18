package online.advertisement.system.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.exception.UserNotFoundException;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.AppUserService;

@RestController()
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
		LOG.info(appUser.getUsername());
		LOG.info(appUser.getPassword());
		AppUser appUser2 = userService.login(appUser);
		if ((appUser.getUsername().equals(appUser2.getUsername())
				&& (appUser.getPassword().equals(appUser2.getPassword())))) {
			return appUser2;
		} else
			throw new UserNotFoundException();
	}

// Logout
	@GetMapping("/logout")
	public String logout() {
		LOG.info("logout");
		return userService.logout();
	}

}