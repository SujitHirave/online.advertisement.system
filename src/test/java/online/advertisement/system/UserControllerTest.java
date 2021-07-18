package online.advertisement.system;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import online.advertisement.system.service.CategoryService;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationTest.class)
public class UserControllerTest {
	@Autowired
	private CategoryService service;
}