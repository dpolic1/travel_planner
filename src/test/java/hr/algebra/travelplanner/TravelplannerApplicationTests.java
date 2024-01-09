package hr.algebra.travelplanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TravelplannerApplicationTests {
  @Autowired private MockMvc mockMvc;

  @Test
  void contextLoads() {}

  @Test
  void testUnauthenticated() throws Exception {
    mockMvc
        .perform(MockMvcRequestBuilders.get("/countries").contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isUnauthorized()); // Expecting a 401 Unauthorized status
  }
}
