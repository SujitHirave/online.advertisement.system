package online.advertisement.system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.repository.AppUserRepository;


@Service
public class AppUserService {

	private static final Logger LOG = LoggerFactory.getLogger(AppUserService.class);

	@Autowired
	private AppUserRepository repository;

	private AppUser currentAppUser; // access control to APIs
	
	//RegisterUser
	public AppUser registerUser(AppUser appusers) {
		LOG.info("RegisterUser");
		return repository.save(appusers);
	}
	
	//login
	public AppUser login(AppUser appUser) {
		LOG.info("loginService");
//		currentAppUser = repository.findByUsernameAndPassword(appUser.getUsername() , appUser.getPassword());
		currentAppUser = repository.findByUsername(appUser.getUsername());
//		System.out.println(currentAppUser);
		return currentAppUser; 
	}

//logout
	public String logout() {
		LOG.info("logoutService");
		currentAppUser = null;
		return "User logged out successfully";
	}
	
	//login status
	public AppUser loginStatus() {
		LOG.info("loginStatusService");
//		currentAppUser = repository.findByUsername();
		return currentAppUser;
	}
	
	
	

	
		
	

////	View user list
//	public List<AppUser> getUsersList() {
//		LOG.info("viewUserList");
//		 return repository.viewUserList();
//	}

//	public Advertise findReadAdvertiseById(int catid) {
//		LOG.info("findEmployeeById");
//		return repository.findById(catid).get();	
//
//	}

//	public User registerUser(User users) {
//		LOG.info("addUser");
//		return repository.save(users);
//	}

//	public Advertise findReadAdvertiseById(int catid) {
//		
//			LOG.info("findAdvertiseById");
//			return repository.findById(catid).get();	
//			
//	}

//	public List<Advertise> getAdvertiseByName(String advertisetitle) {
//		LOG.info("findAdvertiseByName");
//		return repository.findByName(advertisetitle);
//	}
	
	
}