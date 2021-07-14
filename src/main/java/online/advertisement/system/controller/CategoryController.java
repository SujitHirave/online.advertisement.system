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
import online.advertisement.system.model.Category;
import online.advertisement.system.service.CategoryService;

//
//import online.advertisement.system.model.Advertise;
//import online.advertisement.system.model.AppUser;
//import online.advertisement.system.model.Category;
//import online.advertisement.system.service.CategoryService;
//import online.advertisement.system.service.AdvertiseService;
//import online.advertisement.system.service.UserService;

//import com.cg.spring.boot.demo.model.User;//
//import com.cg.spring.boot.demo.service.UserService;


//@RestController("/user")
@RestController
public class CategoryController {

	private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService service;

// Add category	
	@PostMapping("/admin/addcategory")
	public Category addCategory( Category cat) {
		LOG.info("addproduct");
		return service.addCategory(cat);
	}
	
//	view Category
	@GetMapping("/getall")
	private List<Category> getAllCat() {
		LOG.info("ViewCategory");
		return service.getAllCategory();
	}
	

//	Delete category by id
	@DeleteMapping("/admin/deletecat/{catid}")
	public void deleteCat(@PathVariable int catid) {
		LOG.info("deleteCategory");
		service.deleteCategory(catid);
	}
	

	}