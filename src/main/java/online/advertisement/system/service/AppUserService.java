package online.advertisement.system.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.repository.AppUserRepository;

/**
 * 
 * 
 * Service for Registration, Login and Logout functionalities
 *
 */

@Service
public class AppUserService {

	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private AppUserRepository repository;

	private AppUser currentAppUser; // access control to APIs

//	Registration for Admin and User
	public AppUser registerUser(AppUser appusers) {
		LOG.info("Registered Successfully");
		return repository.save(appusers);
	}

// Login
	public AppUser login(AppUser appUser) {
		LOG.info("LoginService");
		currentAppUser = repository.findByUsername(appUser.getUsername());
		return currentAppUser;
	}

// logout
	public String logout() {
		LOG.info("logoutService");
		currentAppUser = null;
		return " Logged out successfully";
	}

// login status
	public AppUser loginStatus() {
		LOG.info("loginStatusService");
		return currentAppUser;
	}

}