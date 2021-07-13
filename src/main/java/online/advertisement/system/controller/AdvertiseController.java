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
import org.springframework.web.bind.annotation.RestController;


import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.AdvertiseService;
import online.advertisement.system.service.UserService;

//import com.cg.spring.boot.demo.model.User;//
//import com.cg.spring.boot.demo.service.UserService;


//@RestController("/user")
@RestController
public class AdvertiseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdvertiseController.class);

	@Autowired
	private AdvertiseService service;

	
//	@PostMapping("/register") 
//	public AppUser postUser(@RequestBody AppUser users) {
//		LOG.info("user");
//		return service.registerUser(users);
//		
//	}
//	
	
	
	
	@GetMapping("/getAdvByName/{advertisetitle}")
	private List<Advertise> getAdvertise(@PathVariable("advertisetitle") String advertisetitle) {
		return service.getAdvertiseByName(advertisetitle);
	}
}
