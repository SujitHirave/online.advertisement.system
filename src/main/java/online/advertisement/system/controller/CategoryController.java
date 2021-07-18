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
import online.advertisement.system.service.AppUserService;
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

	@Autowired
	AppUserService appUserService;

// Add category	
	@PostMapping("/admin/addCategory")
	public Category addCategory(@RequestBody Category cat) {
		LOG.info("addproduct");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.addCategory(cat);
		return null;
	}

//	view Category
	@GetMapping("/adminORuser/getAllCategory")
	private List<Category> getAllCat() {
		LOG.info("ViewCategory");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.getAllCategory();
		return null;
	}

//	Find category by category name
//	@GetMapping("/getcatbyname/{catname}")
//	public List<Category> getCatBycatname(@PathVariable("catname") String catname) {
//		LOG.info("getEmpByEname");
//		if (appUserService.loginStatus().getRole().toString().equals("USER"))
//		return service.findCategoryBycatname( catname);
//		return null;
//	}

//	 method that returns ResponseEntity
	@GetMapping("/getCategory/{catid}")
	public ResponseEntity<Category> getCategoryBycatid(@PathVariable("catid") int catid) {
		LOG.info("getcat");
		Category cat = service.findCategoryBycatid(catid);
		HttpHeaders headers = new HttpHeaders();
		if (cat != null) {
			headers.add("Category name", cat.getCatname());
			return new ResponseEntity<Category>(cat, headers, HttpStatus.OK);
		} else {
			headers.add("Category name", "Name not available");
			return new ResponseEntity<Category>(cat, headers, HttpStatus.NOT_FOUND);
		}
	}

//	Delete category by id
	@DeleteMapping("/admin/deleteCategory/{catid}")
	public void deleteCat(@PathVariable int catid) {
		LOG.info("deleteCategory");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			service.deleteCategory(catid);
	}

}