package online.advertisement.system.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.repository. AdminUserRepository;


@Service
public class AdminUserService {

	private static final Logger LOG = LoggerFactory.getLogger(AdminUserService.class);

	@Autowired
	private  AdminUserRepository repository;

	
	
//	edit user
	public  AppUser editUserProfile(AppUser edit) {
		LOG.info("UpdateUser");
		
			return repository.save(edit);
		
	}
	
	
//	View user details
	public List<AppUser> getAllUsers() {
		LOG.info("ViewAllUsers");
		return repository.findAll();
	}

//	Delete User
	public void deleteUser(int userid) {
		LOG.info("deleteUser-service");
		 repository.deleteById(userid);
	
		
	}

//	View user list
	public List<String> getUsersList() {
		LOG.info("viewUserList");
		 return repository.viewUserList();
	}

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