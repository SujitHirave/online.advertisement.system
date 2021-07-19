package online.advertisement.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import online.advertisement.system.model.Category;
import online.advertisement.system.service.CategoryService;

/**
 * 
 * Controller for testing Category functionalities
 *
 */
@SpringBootTest
public class CategoryControllerTest {

	private static Logger LOG = LoggerFactory.getLogger(CategoryControllerTest.class);

	@MockBean
	private CategoryService service;

// Positive test case for findCategoryBycatid()
	@Test
	public void testgetCategoryBycatid() {
		LOG.info("testfindCategoryBycatid");
		Category obj = new Category(1, "mobiles");
		when(service.findCategoryBycatid(1)).thenReturn(obj); // actual
		String catname = "mobiles"; // unexpected
		assertEquals(catname, service.findCategoryBycatid(1).getCatname()); // assertEquals(expected, actual)

	}

//  Negative test case for findCategoryBycatid()
	@Test
	public void testgetCategoryBycatidNegative() {
		LOG.info("testfindCategoryBycatid");
		Category obj = new Category(1, "mobile");
		when(service.findCategoryBycatid(1)).thenReturn(obj); // actual
		String catname = "Laptop"; // unexpected
		assertNotEquals(catname, service.findCategoryBycatid(1).getCatname()); // assertEquals(expected, actual)
	}

//  Positive test case for addCategory()
	@Test
	public void addCategory() {
		LOG.info("testfindCategoryBycatid");
		Category obj = new Category(1, "mobiles");
		when(service.addCategory(obj)).thenReturn(obj);
		assertEquals(obj, service.addCategory(obj)); // assertEquals(expected, actual)
	}

// Negative test case for  addCategory()
	@Test
	public void addCategoryNegative() {
		LOG.info("testfindCategoryBycatid");
		Category obj = new Category(1, "mobiles");
		Category obj1 = new Category(1, "laptop");
		when(service.addCategory(obj)).thenReturn(obj);
		assertNotEquals(obj1, service.addCategory(obj)); // assertEquals(expected, actual)
	}
}