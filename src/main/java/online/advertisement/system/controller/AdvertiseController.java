package online.advertisement.system.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.model.Advertise;
import online.advertisement.system.service.AdvertiseService;
import online.advertisement.system.service.AppUserService;

/**
 * 
 * controller for Advertise functionalities
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:3005")
public class AdvertiseController {

	private static final Logger LOG = LoggerFactory.getLogger(AdvertiseController.class);

	@Autowired
	private AdvertiseService service;

	@Autowired
	AppUserService appUserService;

//	To post advertise
	@PostMapping("/user/seller/AddNewAdv")
	public Advertise addNewProduct(@RequestBody Advertise adv) {
		LOG.info("addproduct");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.addAdvertise(adv);
		return null;
	}

//	Seller can edit or update his advertise details 
//	@PutMapping("/user/seller/editAdv")
//	public void updateProduct(   @PathVariable("advid") int advid ,  @PathVariable("advertisetitle") String advertisetitle, @PathVariable("price") double price, @PathVariable("description") String description, @PathVariable("advownername") String advownername
//			) {
//		LOG.info("updateproduct");
////		if (appUserService.loginStatus().getRole().toString().equals("USER"))
//			service.updateAdvertise(advid, advertisetitle, price, description, advownername);
//
//	}
	@PutMapping("/user/seller/editAdv")
	public void updateProduct( @RequestBody Advertise adv  ) {
		LOG.info("updateproduct");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			 service.updateAdvertise(adv);

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
	public void updateStatus( int advid, String status) {
//	public void updateStatus(@PathVariable("advid") int advid, String status) {
//		LOG.info("updateStatus");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			service.updateAdvStatus(advid, status);
	}

//	Buyer can view all the approved advertises posted by the seller
	@GetMapping("/user/buyer/getAllApprovedAdv")
	private List<Advertise> getApprovedAdv() {
		LOG.info("ViewAdvertises");
//		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getApprovedAdvs();
//		return null;
	}

//	user can also search for advertises by advertisetitle
	@GetMapping("/user/getAdvertise/{advertisetitle}")
	public List<Advertise> getAdvertiseByadvertisetitle(String advertisetitle) {
		LOG.info("getadvbytitle");
		if (appUserService.loginStatus().getRole().toString().equals("USER")) {
			return service.findAdvertiseByadvertisetitle(advertisetitle);
		}
		return null;
	}

// seller can view advertise 
	@GetMapping("/user/seller/getAllAdv")
	private List<Advertise> getAllAdv() {
		LOG.info("ViewAdvertises");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getAllAdvertises();
		return null;
	}

//	seller can view the specific advertise  by id posted by seller
	@GetMapping("/user/seller/getAdv/{advid}")
	public ResponseEntity<Advertise> getAdvertiseByadvid(@PathVariable("advid") int advid) {
		LOG.info("advertise");
		Advertise adv = service.findAdvertiseByadvid(advid);
		HttpHeaders headers = new HttpHeaders();
		if (adv != null) {
			headers.add("Advertise name", adv.getAdvertisetitle());
			return new ResponseEntity<Advertise>(adv, headers, HttpStatus.OK);
		} else {
			headers.add("Advertise name", "Category not available");
			return new ResponseEntity<Advertise>(adv, headers, HttpStatus.NOT_FOUND);
		}
	}

	// Seller can delete his posted advertise
	@DeleteMapping("/user/seller/deleteAdv/{advid}")
	public void deleteAdv(@PathVariable int advid) {
		LOG.info("deleteadvertise");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			service.deleteAdvertise(advid);
	}
}