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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import online.advertisement.system.model.Category;
import online.advertisement.system.service.AppUserService;
import online.advertisement.system.service.CategoryService;

/**
 * 
 * controller for Category functionalities
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:3005")
public class CategoryController {

	private static final Logger LOG = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	private CategoryService service;

	@Autowired
	AppUserService appUserService;

// Admin can add category
	@PostMapping("/admin/addCategory")
	public Category addCategory(@RequestBody Category cat) {
		LOG.info("addcategory");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			return service.addCategory(cat);
		return null;
	}

//	User can view category
	@GetMapping("/user/getAllCategory")
	private List<Category> getAllCat() {
		LOG.info("ViewCategory");
		if (appUserService.loginStatus().getRole().toString().equals("USER"))
			return service.getAllCategory();
		return null;
	}

//	Admin and user can view category by category id
	@GetMapping("/getCategory/{catid}")
	public ResponseEntity<Category> getCategoryBycatid(@PathVariable("catid") int catid) {
		LOG.info("getcat");
		Category cat = service.findCategoryBycatid(catid);
		HttpHeaders headers = new HttpHeaders();
		if (cat != null) {
			headers.add("Category name", cat.getCatname());
			return new ResponseEntity<Category>(cat, headers, HttpStatus.OK);
		} else {
			headers.add("Category name", "Category not available");
			return new ResponseEntity<Category>(cat, headers, HttpStatus.NOT_FOUND);
		}
	}

//	Admin can delete a category by category id
	@DeleteMapping("/admin/deleteCategory/{catid}")
	public void deleteCat(@PathVariable int catid) {
		LOG.info("deleteCategory");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN"))
			service.deleteCategory(catid);
	}

}