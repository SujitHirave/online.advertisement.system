package online.advertisement.system.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.advertisement.system.model.User;

//import com.cg.spring.boot.demo.model.Employee;

import online.advertisement.system.repository.UserRepository;

//import com.cg.spring.boot.demo.exception.EmployeeNotFoundException;
//import com.cg.spring.boot.demo.model.Employee;
//import com.cg.spring.boot.demo.repository.EmployeeRepository;

@Service
public class UserService {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository repository;

	public User registerUser(User users) {
		LOG.info("addUser");
		return repository.save(users);
	}
}