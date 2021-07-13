package online.advertisement.system.service;






import java.util.List;
import java.util.Locale.Category;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.repository.AdvertiseRepository;
import online.advertisement.system.repository.CategoryRepository;
import online.advertisement.system.repository.UserRepository;


@Service
public class CategoryService {

	private static final Logger LOG = LoggerFactory.getLogger(CategoryService.class);

	@Autowired
	private CategoryRepository repository;

	public Category addCategory(Category cat) {
		// TODO Auto-generated method stub
		LOG.info("addCategory");
		return repository.save(cat);
	}



	
//	public  Category addCategory(Category cat) {
//		
//			LOG.info("addCategory");
//			return repository.save(cat);
//		}

		
	}
	
	
