package online.advertisement.system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Locale.Category;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


public class CategoryControllerTest extends AbstractTest {
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }
   @Test
   public void getProductsList() throws Exception {
      String uri = "/category";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Category[] categorylist = super.mapFromJson(content, Category[].class);
      assertTrue(categorylist.length > 0);
   }
//   

   @Test
   public void getAllCategory() throws Exception {
      String uri = "/category";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      Category[] productlist = super.mapFromJson(content, Category[].class);
      assertTrue(productlist.length > 0);
   }
   @Test
   public void deleteCategory() throws Exception {
      String uri = "/category/1";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
      String content = mvcResult.getResponse().getContentAsString();
      assertEquals(content, "Category is deleted successsfully");
   }
//   @Test
//   public void addCategory() throws Exception {
//      String uri = "/category";
//      Category cat = new Category();
//      cat.setCatid("1");
//      cat.setCatname("child");
//      
//      String inputJson = super.mapToJson(cat);
//      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//         .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
//      
//      int status = mvcResult.getResponse().getStatus();
//      assertEquals(201, status);
//      String content = mvcResult.getResponse().getContentAsString();
//      assertEquals(content, "Category is created successfully");
//   }
   
}