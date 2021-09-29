package training.day3;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class FirstRestAssuredClass {

    @Test
    void test(){
        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
//        System.out.println(response.headers());
//        System.out.println(response.contentType());
//        System.out.println(response.peek());
    }
}
