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
import online.advertisement.system.repository.AdvertiseRepository;
import online.advertisement.system.repository.UserRepository;


@Service
public class AdvertiseService {

	private static final Logger LOG = LoggerFactory.getLogger(AdvertiseService.class);

	@Autowired
	private AdvertiseRepository repository;

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
//		LOG.info("findAdvertiseById");
//		return repository.findById(catid).get();	
//	}

	public List<Advertise> getAdvertiseByName(String advertisetitle) {
		LOG.info("findAdvertiseByName");
		return repository.findByadvertisetitle("laptop on sale");
	}

	public Advertise addAdvertise(Advertise adv) {
		
			LOG.info("addProduct");
			return repository.save(adv);
		}

		
	}
	
	
