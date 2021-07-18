package online.advertisement.system;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	private static Logger LOG = LoggerFactory.getLogger(ApplicationTests.class);

	// positive test case
	@Test
	public void testHello() {
		LOG.info("testHello");
		Hello obj = new Hello();
		String s1 = "Hello world!"; // password vaman123
		String s2 = obj.hello();
		assertEquals(s2, s1);

	}

	// negative test case
	@Test
	public void testHelloNegative() {
		LOG.info("testHello");
		Hello obj = new Hello();
		String unexpected = "anyOtherValue"; // password suresh123
		String actual = obj.hello();
		assertNotEquals(unexpected, actual);
	}
}