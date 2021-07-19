package online.advertisement.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import online.advertisement.system.model.AppUser;
import online.advertisement.system.service.AppUserService;

/**
 * 
 * Controller for testing Login functionalities
 *
 */
@SpringBootTest
public class LoginControllerTest {

	private static Logger LOG = LoggerFactory.getLogger(LoginControllerTest.class);

	@MockBean
	private AppUserService userService;

//  Positive test case-login()
	@Test
	public void testlogin() {
		LOG.info("testLogin");
		AppUser appUser1 = new AppUser("user123", "pass");
		AppUser appUser2 = userService.login(new AppUser("user123", "pass"));
		when(userService.login(appUser2)).thenReturn(appUser1); // actual
		String password = "pass"; // expected
		assertEquals(password, userService.login(appUser2).getPassword()); // assertEquals(expected, actual)
	}

//  Negative test case-login()
	@Test
	public void testloginNegative() {
		LOG.info("testLogin");
		AppUser appUser1 = new AppUser("user123", "passw");
		AppUser appUser2 = userService.login(new AppUser("user123", "passw"));
		when(userService.login(appUser2)).thenReturn(appUser1); // actual
		String password = "pass"; // unexpected
		assertNotEquals(password, userService.login(appUser2).getPassword()); // assertEquals(unexpected, actual)

	}

}