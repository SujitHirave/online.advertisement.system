package online.advertisement.system;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.Category;
import online.advertisement.system.service.AdvertiseService;
import online.advertisement.system.service.CategoryService;

@SpringBootTest
public class CategoryControllerTest {

	private static Logger LOG = LoggerFactory.getLogger(CategoryControllerTest.class);

	@MockBean
	private CategoryService service;
	
// Positive test case
	@Test
	public void  testgetCategoryBycatid()  {
		LOG.info("testfindCategoryBycatid");
		Category  obj= new Category(1, "mobiles");
		 when(service.findCategoryBycatid(1)).thenReturn(obj);       // actual
		 
		 String catname="mobiles";                                //expected
		 
		assertEquals(catname,service.findCategoryBycatid(1).getCatname()); //assertEquals(expected, actual)
		
	}
	
//  Negative test case	
	
	@Test
	public void  testgetCategoryBycatidNeg()  {
		LOG.info("testfindCategoryBycatid");
		Category  obj= new Category(1, "mobile");
		 when(service.findCategoryBycatid(1)).thenReturn(obj);       // actual
		 
		 String catname="mobileS";                                //expected
		 
		assertEquals(catname,service.findCategoryBycatid(1).getCatname()); //assertEquals(expected, actual)
		
	}

}