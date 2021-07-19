package online.advertisement.system.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import online.advertisement.system.exception.AdvertiseNotFoundException;
import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.Category;
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

//	Admin will Read all advertises posted by user(for changing status)
	public List<Advertise> getAllAdvertises() {
		LOG.info("ViewAllAdvertises");
		return repository.findAll();
	}

//	Read the specific advertise by id(seller)
	public Advertise getAdvertiseById(int advid) {
		LOG.info("Advertise");
		return repository.getByadvid(advid);
	}

//	Post New Advertise(Selling)
	public void addAdvertise(int advid, String advertisetitle, double price, String description, String advownername,
			int catid) {
		LOG.info("addProduct");
		repository.addSellerAdv(advid, advertisetitle, price, description, advownername, catid);
	}

//	User will update advertise details (seller)
	public void updateAdvertise(int advid, String advertisetitle, double price, String description, String advownername,
			int catid) {
		LOG.info("updateProduct");
		repository.updateSellerAdv(advertisetitle, price, description, advownername, catid, advid);
	}

//	Admin will update status of advertise
	public void updateAdvStatus(int advid, String status) {
		LOG.info("UpdateStatus");
		repository.updateStatusAdv(status, advid);
	}

//	public Advertise updateAdvertise(Advertise adv) {
//		LOG.info("updateProduct");
//		return repository.save(adv);
//	}

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

//	 method that works with custom exception	
	public Advertise findAdvertiseByadvertisetitle(String advertisetitle) {
		LOG.info("findAdvertiseByadvertisetitle");
		Optional<Advertise> optAdv = repository.findByAdvertisetitle(advertisetitle);
		if (optAdv.isEmpty())
			throw new AdvertiseNotFoundException();
		else
			return optAdv.get();
	}

//search product by text
//	public List<Advertise> getAdvertiseByText(String advertisetitle, double price, String description,
//			Category category) {
//		LOG.info("Search by Text");
//		return repository.searchproductByText();
//	}
}
