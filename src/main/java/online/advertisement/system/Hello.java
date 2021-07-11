package online.advertisement.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
    	LOG.info("Hello venu");
        return "Hello world ok!";
    }

 

}