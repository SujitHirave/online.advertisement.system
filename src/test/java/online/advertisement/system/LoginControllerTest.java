package online.advertisement.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.AppUserService;

@SpringBootTest
public class LoginControllerTest {

	private static Logger LOG = LoggerFactory.getLogger(LoginControllerTest.class);

	@MockBean
	private AppUserService userService;

 //Positive test case
	@Test
	public void  testlogin()  {
		LOG.info("testLogin");
		AppUser appUser = userService.login(new AppUser("user","pass"));
//		if ((appUser.getUsername().equals(appUser2.getUsername())
//				&& (appUser.getPassword().equals(appUser2.getPassword())))) {
//			return appUser2;
//		}
		 when(userService.login(appUser).getUsername()).thenReturn("user");       // actual
		 
		 String username="user";
		// String password="pass";
			
		 
		assertEquals(username, appUser.getUsername()); //assertEquals(expected, actual)
		
	}
	
//	// Positive test case
//		@Test
//		public void  testlogin()  {
//			LOG.info("testLogin");
//			AppUser appUser2 = userService.login(appUser2);
//			 when(userService.login("user123")).thenReturn(appUser2);       // actual
//			 
//			 String username="user123";                                //expected
//			 
//			assertEquals(username,userService.login(username).getusername()); //assertEquals(expected, actual)
//			
//		}

}