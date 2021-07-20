package online.advertisement.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import online.advertisement.system.model.Advertise;
import online.advertisement.system.model.Category;
import online.advertisement.system.service.AdvertiseService;

/**
 * 
 * Controller for testing Advertise functionalities
 *
 */

@SpringBootTest
public class AdvertiseControllerTest {

	private static Logger LOG = LoggerFactory.getLogger(AdvertiseControllerTest.class);

	@MockBean
	private AdvertiseService service;

	// Positive test case for service.getAdvertiseById)
	@Test
	public void testgetAdvertiseById () {
		LOG.info("testfindAdvertiseByid");
		Advertise obj = new Advertise(11, "APPROVED");
		when(service.findAdvertiseByadvid(11)).thenReturn(obj); // actual
		String status = "APPROVED"; // expected
		assertEquals(status, service.findAdvertiseByadvid(11).getStatus()); // assertEquals(expected, actual)
	}

	// Negative test case for service.getAdvertiseById()
	@Test
	public void testgetAdvertiseByIdNegative() {
		LOG.info("testfindAdvertiseByidNegative");
		Advertise obj = new Advertise(11, "APPROVED");
		when(service.findAdvertiseByadvid(11)).thenReturn(obj); // actual
		String status = "APPROV"; // expected
		assertNotEquals(status, service.findAdvertiseByadvid(11).getStatus()); // assertEquals(expected, actual)
	}


}