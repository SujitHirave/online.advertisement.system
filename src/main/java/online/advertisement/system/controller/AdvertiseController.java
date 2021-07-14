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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jdk.internal.org.jline.utils.Log;
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

//	For Adding Products(Selling)
	@PostMapping("/addproduct")
	public Advertise addProduct( Advertise adv) {
		LOG.info("addproduct");
		System.out.println(adv);
		return service.addAdvertise(adv);
	}

//	For getting products(Buying)
	@GetMapping("/getAdvByName/{advertisetitle}")
	private List<Advertise> getAdvertise(@PathVariable("advertisetitle") String advertisetitle) {
		return service.getAdvertiseByName(advertisetitle);
	}
	
// Read all advertises posted by user
	@GetMapping("/getAllAdv")
	private List<Advertise> getAllAdv(){
		LOG.info("ViewAdvertises");
		return service.getAllAdvertises();
	}
	
//	get by id
	@GetMapping("/getadv/{advid}")
	public Advertise getAdvertiseById(@PathVariable("advid") int advid) {
		LOG.info("advertise");

		return service.getAdvertiseById(advid);
	}
	
	
	
//	Update advertise product
	@PutMapping("/updateadv")
	public Advertise updateAdv(@RequestBody Advertise adv) {
		LOG.info("updateProduct");
		return service.updateAdvertise(adv);
	}
	
	
	
////	For deleting Products
//	@DeleteMapping("deleteadv/{advertisetitle}")
//	public String deleteAdv(@PathVariable("advertisetitle") String advertisetitle) {
//		LOG.info("deleteProduct");
//		return service.deleteAdvertise(advertisetitle);
//	}
	
//	Delete product by id
	@DeleteMapping("/deleteadv/{advid}")
	public void deleteAdv(@PathVariable int advid) {
		LOG.info("deleteProduct");
		service.deleteAdvertise(advid);
	}
}
