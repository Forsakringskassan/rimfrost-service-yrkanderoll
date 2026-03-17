package se.fk.github.rimfrost.yrkanderoll;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.GetYrkanderollResponse;
import se.fk.rimfrost.jaxrsspec.controllers.generatedsource.model.Yrkanderoll;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class YrkanderollControllerTest
{
   private static final ObjectMapper mapper = new ObjectMapper();

   @Test
   void testYrkanderollController() throws JsonProcessingException
   {
      var expectedYrkanderoll = new Yrkanderoll();
      expectedYrkanderoll.setId(UUID.fromString("a60a67d6-cfb6-41ad-9718-49e2f9e6b9ba"));
      expectedYrkanderoll.setVersion("1.0");
      expectedYrkanderoll.setNamn("Sökande");

      var expectedResponse = new GetYrkanderollResponse();
      expectedResponse.setYrkanderoll(expectedYrkanderoll);

      String actualResponse = given()
            .when().get("/yrkanderoll/a60a67d6-cfb6-41ad-9718-49e2f9e6b9ba")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetYrkanderollResponse.class);
      assertEquals(expectedResponse, response);
   }

   @Test
   void testYrkanderollWithDifferentId() throws JsonProcessingException
   {
      var expectedYrkanderoll = new Yrkanderoll();
      expectedYrkanderoll.setId(UUID.fromString("235520e4-8715-43ad-b902-fa684cf63a18"));
      expectedYrkanderoll.setVersion("1.0");
      expectedYrkanderoll.setNamn("Sökande");

      var expectedResponse = new GetYrkanderollResponse();
      expectedResponse.setYrkanderoll(expectedYrkanderoll);

      String actualResponse = given()
            .when().get("/yrkanderoll/235520e4-8715-43ad-b902-fa684cf63a18")
            .then()
            .statusCode(200)
            .extract()
            .body()
            .asString();

      var response = mapper.readValue(actualResponse, GetYrkanderollResponse.class);
      assertEquals(expectedResponse, response);
   }
}
