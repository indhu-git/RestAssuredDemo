package training.day8;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import  static  org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class Day8Example {

@Test
    public void day8Example(){
    Map<String, String> queryParams = new HashMap<>();
    queryParams.put("key", "3f2e4eca21e892561fdf169d912fd7ab");
    queryParams.put("token", "5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510");

    given().when().body("")
            .get("https://api.trello.com/1/boards/RG0pqXo2")
           //Assertion
            .then()
            .assertThat()
//            .body("id", equalTo("614a909f672fdf793c8f0a9a"))
//            .body("name", hasItem("Board for API Automation"))
            .body(matchesJsonSchemaInClasspath("schemavalidation.json"))
            .statusCode(200);
//            .log().all();
}
        //https://jsonpathfinder.com/
}
