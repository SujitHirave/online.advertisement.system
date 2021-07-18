package online.advertisement.system;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.common.net.MediaType;

import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.AppUserService;
import online.advertisement.system.service.CategoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationTest.class)
public class UserControllerTest {
	@Autowired
	private CategoryService service;

//	@Autowired
//	AppUserService appUserService;

//	   @Test
//	   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
//	      Mockito.when(service.findCategoryBycatid(0)).thenReturn("Mock Product Name");
//	      String testName = service.findCategoryBycatid(0);
//	      Assert.assertEquals("Mock Product Name", catid);
//	   }
}