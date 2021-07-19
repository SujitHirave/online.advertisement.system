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
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.Category;
import online.advertisement.system.service.AdvertiseService;
import online.advertisement.system.service.AppUserService;

/**
 * 
 * controller for Advertise functionalities
 *
 */

@RestController
public class AdvertiseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdvertiseController.class);

	@Autowired
	private AdvertiseService service;

	@Autowired
	AppUserService appUserService;

//	To post advertise
	@PostMapping("/user/seller/AddNewAdv")
	public void addNewProduct(int advid, String advertisetitle, double price, String description, String advownername,
			int catid) {
		LOG.info("addproduct");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.addAdvertise(advid, advertisetitle, price, description, advownername, catid);
	}

//	Seller can edit or update his advertise details 
	@PutMapping("/user/seller/editAdv")
	public void updateProduct(int advid, String advertisetitle, double price, String description, String advownername,
			int catid) {
		LOG.info("updateproduct");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.updateAdvertise(advid, advertisetitle, price, description, advownername, catid);

	}

//	Admin can view all the advertises posted by the seller for changing the status 
	@GetMapping("/admin/getAllAdv")
	private List<Advertise> getAllAdvA() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.getAllAdvertises();
		return null;
	}

//	Admin can update the status posted by the seller
	@PutMapping("/admin/updateStatus")
	public void updateStatus(int advid, String status) {
		LOG.info("updateStatus");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			service.updateAdvStatus(advid, status);
	}

//	Buyer can view all the approved advertises posted by the seller
	@GetMapping("/user/buyer/getAllApprovedAdv")
	private List<Advertise> getApprovedAdv() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getApprovedAdvs();
		return null;
	}

//	Search Advertise by text entered in textbox(seller)
//	@GetMapping("/user/seller/getAdvByText/{text}")
//	private List<Advertise> getAdvertise(String advertisetitle, double price, String description, Category category) {
//		return service.getAdvertiseByText(advertisetitle,price, description,  category);
//	}

//	Buyer can also search for advertises by advertisetitle
	@GetMapping("/user/buyer/getAdvertise/{advertisetitle}")
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

// Buyer can view all the advertises posted by the seller
	@GetMapping("/user/buyer/getAllAdv")
	private List<Advertise> getAllAdv() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getAllAdvertises();
		return null;
	}

//	Buyer can view the specific advertise  by id posted by seller
	@GetMapping("/user/seller/getAdv/{advid}")
	public Advertise getAdvertiseById(@PathVariable("advid") int advid) {
		LOG.info("advertise");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getAdvertiseById(advid);
		return null;
	}


//	Seller can delete his posted advertise 
	@DeleteMapping("/user/seller/deleteAdv/{advid}")
	public void deleteAdv(@PathVariable int advid) {
		LOG.info("deleteadvertise");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.deleteAdvertise(advid);
	}
}