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
import online.advertisement.system.service.AppUserService;

//import com.cg.spring.boot.demo.model.User;//
//import com.cg.spring.boot.demo.service.UserService;

//@RestController("/user")
@RestController
public class AdvertiseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdvertiseController.class);

	@Autowired
	private AdvertiseService service;

	@Autowired
	AppUserService appUserService;

//	Post New Advertise(Selling)
	@PostMapping("/user/seller/AddNewAdv")
	public void addNewProduct(int advid, String advertisetitle, double price, String description, String advownername,
			int catid) {
		LOG.info("addproduct");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.addAdvertise(advid, advertisetitle, price, description, advownername, catid);
	}

//	User will update or edit advertise details (seller)
	@PutMapping("/user/seller/editAdv")
	public void updateProduct(int advid, String advertisetitle, double price, String description, String advownername,
			int catid) {
		LOG.info("updateproduct");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.updateAdvertise(advid, advertisetitle, price, description, advownername, catid);

	}

//	Admin will Read all advertises posted by user(for changing status)
	@GetMapping("/admin/getAllAdv")
	private List<Advertise> getAllAdvA() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.getAllAdvertises();
		return null;
	}

//	Admin will update status of advertise
	@PutMapping("/admin/updateStatus")
	public void updateStatus(int advid, String status) {
		LOG.info("updateStatus");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			service.updateAdvStatus(advid, status);
	}

//	show approved advertise for buyer
	@GetMapping("/user/buyer/getAllApprovedAdv")
	private List<Advertise> getApprovedAdv() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getApprovedAdvs();
		return null;
	}

//	Search Advertise by text entered in textbox(seller)
//	@GetMapping("/user/seller/getAdvByName/{advertisetitle}")
//	private List<Advertise> getAdvertise(@PathVariable("advertisetitle") String advertisetitle) {
//		return service.getAdvertiseByName(advertisetitle);
//	}

//	 method that returns ResponseEntity
	@GetMapping("/user/seller/getAdvertise/{advertisetitle}")
	public ResponseEntity<Advertise> getAdvertiseByadvertisetitle(
			@PathVariable("advertisetitle") String advertisetitle) {
		LOG.info("getadv");
		Advertise adv = service.findAdvertiseByadvertisetitle(advertisetitle);
		HttpHeaders headers = new HttpHeaders();
		if (adv != null) {
			headers.add("Advertise name", adv.getAdvertisetitle());
			return new ResponseEntity<Advertise>(adv, headers, HttpStatus.OK);
		} else {
			headers.add("Advertise name", "Name not available");
			return new ResponseEntity<Advertise>(adv, headers, HttpStatus.NOT_FOUND);
		}
	}

// Read all advertises posted by seller
	@GetMapping("/user/seller/getAllAdv")
	private List<Advertise> getAllAdv() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getAllAdvertises();
		return null;
	}

//	Read the specific advertise by id(seller)
	@GetMapping("/user/seller/getAdv/{advid}")
	public Advertise getAdvertiseById(@PathVariable("advid") int advid) {
		LOG.info("advertise");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getAdvertiseById(advid);
		return null;
	}

////	For deleting Products
//	@DeleteMapping("deleteadv/{advertisetitle}")
//	public String deleteAdv(@PathVariable("advertisetitle") String advertisetitle) {
//		LOG.info("deleteProduct");
//		return service.deleteAdvertise(advertisetitle);
//	}

//	Delete product by id
	@DeleteMapping("/user/seller/deleteAdv/{advid}")
	public void deleteAdv(@PathVariable int advid) {
		LOG.info("deleteProduct-controller");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.deleteAdvertise(advid);
	}
}