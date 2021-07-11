package online.advertisement.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
 //test change by sujithirave temp

=======
 
//test comment sujit11h
>>>>>>> 94cb24b9873b0ab583e0a3e0252e1348f0949da6
@RestController
public class Hello {

 
  Logger LOG= LoggerFactory.getLogger(Hello.class);
  @RequestMapping("/")
  public String welcome() {
  	LOG.info("welcome");
      return "welocome!";
  }
  
  
    @GetMapping("/hello")
    public String hello() {
    	LOG.info("Hello");
        return "Hello world ok!";
    }

 

}