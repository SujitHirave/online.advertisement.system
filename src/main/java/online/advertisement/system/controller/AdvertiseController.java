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
import online.advertisement.system.model.Category;
import online.advertisement.system.model.Message;
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
	
	
	

//	Post New Advertise(Selling)
//	@PostMapping("/user/seller/AddAdvertise")
//	public Advertise addProduct(@RequestBody Advertise adv) {
//		LOG.info("addproduct");
//		return service.addAdvertise(adv);
//	}

//	Post New Advertise(Selling)
	@PostMapping("/user/seller/AddAdvertise")
	public void addProduct( int advid, String advertisetitle, double price, String description,
			String advownername, int catid) {
		LOG.info("addproduct");
		 service.addAdvertise(advid, advertisetitle, price, description, advownername, catid);
	}
	
//	Admin will Read all advertises posted by user(for changing status)
	@GetMapping("/admin/getAllAdv")
	private List<Advertise> getAllAdvA(){
		LOG.info("ViewAdvertises");
		return service.getAllAdvertises();
	}
	
//	Admin will update status of advertise
	@PutMapping("/admin/updateStatus")
	public void updateStatus(int advid, String status) {
		LOG.info("updateStatus");
		service.updateAdvStatus(advid, status);
	}
	

//	show approved advertise for buyer
	@GetMapping("/user/buyer/getAllApprovedAdv")
	private List<Advertise> getApprovedAdv(){
		LOG.info("ViewAdvertises");
		return service.getApprovedAdvs();
	}
	
//	Search Advertise by text entered in textbox(seller)
	@GetMapping("/user/seller/getAdvByName/{advertisetitle}")
	private List<Advertise> getAdvertise(@PathVariable("advertisetitle") String advertisetitle) {
		return service.getAdvertiseByName(advertisetitle);
	}
	
// Read all advertises posted by seller
	@GetMapping("/user/seller/getAllAdv")
	private List<Advertise> getAllAdv(){
		LOG.info("ViewAdvertises");
		return service.getAllAdvertises();
	}
	
	
//	Read the specific advertise by id(seller)
	@GetMapping("/user/seller/getadv/{advid}")
	public Advertise getAdvertiseById(@PathVariable("advid") int advid) {
		LOG.info("advertise");
		return service.getAdvertiseById(advid);
	}
	

	
	
	
//	Update posted advertise details (seller)
	@PutMapping("/user/seller/updateAdvertise")
	public void updateProduct( int advid, String advertisetitle, double price, String description,
			String advownername, int catid) {
		LOG.info("updateproduct");
		 service.updateAdvertise(advid, advertisetitle, price, description, advownername, catid);
	}
	
	
	
////	For deleting Products
//	@DeleteMapping("deleteadv/{advertisetitle}")
//	public String deleteAdv(@PathVariable("advertisetitle") String advertisetitle) {
//		LOG.info("deleteProduct");
//		return service.deleteAdvertise(advertisetitle);
//	}
	
//	Delete product by id
	@DeleteMapping("/user/seller/deleteadv/{advid}")
	public void deleteAdv(@PathVariable int advid) {
		LOG.info("deleteProduct-controller");
		service.deleteAdvertise(advid);
	}
}
