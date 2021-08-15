package online.advertisement.system.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import online.advertisement.system.exception.AdvertiseNotFoundException;
import online.advertisement.system.model.Advertise;
import online.advertisement.system.repository.AdvertiseRepository;

/**
 * 
 * service for Advertise functionalities
 *
 */

@Service
public class AdvertiseService {

	private static final Logger LOG = LoggerFactory.getLogger(AdvertiseService.class);

	@Autowired
	private AdvertiseRepository repository;

//	Search Advertise by text entered in textbox(seller)
	public List<Advertise> getAdvertiseByName(String advertisetitle) {
		LOG.info("findAdvertiseByName");
		return repository.findByadvertisetitle(advertisetitle);
	}

//	 view advertise all Advertise
	public List<Advertise> getAllAdvertises() {
		LOG.info("ViewAllAdvertises");
		return repository.findAll();
	}

//	Read the specific advertise by id(seller)
	public Advertise findAdvertiseByadvid(int advid) {
		LOG.info("findAdvertiseById");
		Optional<Advertise> optAdv = repository.findByadvid(advid);
		if (optAdv.isEmpty())
			throw new AdvertiseNotFoundException();
		else
			return optAdv.get();
	}

//	Post New Advertise(Selling)
	public Advertise addAdvertise(Advertise adv) {
		LOG.info("addProduct");
		return repository.save(adv);
	}

//	User will update advertise details (seller)
//	public void updateAdvertise(  int advid,  String advertisetitle,double price,  String description, String advownername
//			) {
//		LOG.info("updateProduct");
//		repository.updateSellerAdv(advertisetitle, price, description, advownername, advid);
//	}
	public void updateAdvertise(  Advertise adv  ) {
		LOG.info("updateProduct");
	 repository.save(adv);
		
		
	}	
	


//	Admin will update status of advertise
	public void updateAdvStatus(int advid, String status) {
		LOG.info("UpdateStatus");
		repository.updateStatusAdv(status, advid);
	}

//	Delete product by id
	public void deleteAdvertise(int advid) {
		LOG.info("deleteProduct-service");
		repository.deleteById(advid);

	}

//	show approved advertise for buyer
	public List<Advertise> getApprovedAdvs() {
		LOG.info("ApprovedAdvertise");
		return repository.viewApprovedAdv();
	}

//	 user can also search for advertises by advertisetitle	
	public List<Advertise> findAdvertiseByadvertisetitle(String advertisetitle) {
		LOG.info("findAdvertiseByadvertisetitle");
		return repository.findByadvertisetitle(advertisetitle);
	}

	

}
