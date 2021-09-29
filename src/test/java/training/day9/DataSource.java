package training.day9;

import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class DataSource {

@Test

public void day9(){

    Map<String, String> map = new HashMap<>();
    map.put("username", "unifi");
            map.put("password", "unifiU1!");

                String token = given()
                        .headers("Accept", "application/json, text/plain, */*")
                        .headers("Content-Type", "application/json;charset=UTF-8")
                        .body(new File("src/test/java/training/day9/DataSource.json"))
                        .body(map)
                        .post("http://104.199.173.150:8000/datai-api/get-jwt/")
                        .then()
                        .statusCode(200)
                        .extract()
                        .path("token");
    System.out.println(token);

                    Integer id = given()
                    .headers("Authorization", "Bearer "+token)
                    .headers("Accept", "application/json, text/plain, */*")
                    .headers("Content-Type", "application/json;charset=UTF-8")
                    .body(new File("src/test/java/training/day9/DataSource.json"))
                    .post("http://104.199.173.150:8000/datai-api/data-sources/")
                    .then()
                            .log()
                            .all()
                    .extract()
                            .path("id");
    System.out.println(id);


    //Swagger, Spring


}
}
