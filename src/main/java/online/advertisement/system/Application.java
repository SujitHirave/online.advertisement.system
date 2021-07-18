package online.advertisement.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/***
 * 
 * @author Supriya, Sujit, Venu, Hemant, Shweta, Pooja Deshmukh, Pooja Sathe, Akash
 *
 */

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		LOG.info("Start");
		SpringApplication.run(Application.class, args);
		LOG.info("End");

	}

}