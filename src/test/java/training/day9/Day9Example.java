package training.day9;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import java.io.File;

public class Day9Example {

@Test

public void day9(){

                    Integer id = given()
                    .headers("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MzI0OTIzNDUsImV4cCI6MTYzMjQ5Mjk0NSwiaWQiOjIsInVzZXJuYW1lIjoidW5pZmkiLCJpcF9hZGRyZXNzIjoiNTIuNy4yMTAuMzUiLCJ0b2tlbl9pZCI6NjY2OH0.xobLSiP0NtJBbegMddXnrKeaHU3t0swkRGmN1fjhxDU")
                    .headers("Accept", "application/json, text/plain, */*")
                    .headers("Content-Type", "application/json;charset=UTF-8")
                    .body(new File("src/test/java/training/day9/DataStore.json"))
                    .post("http://104.199.173.150:8000/datai-api/datastores/")
                    .then()
                    .extract()
                            .path("id");
    System.out.println(id);


    //Swagger, Spring


}
}
