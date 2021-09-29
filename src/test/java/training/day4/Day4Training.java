package training.day4;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day4Training {
//GET METHOD
    @Test
    public void day4(){
        Response response = RestAssured.get("https://reqres.in/api/users");
        Assert.assertEquals(response.statusCode(), 201);
        System.out.println(response.getBody().asString());
    }

    //POST EXAMPLE
    @Test
    public void postExample(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Indhu");
        requestBody.put("job", "Tester");
        Response response = RestAssured.given().body(requestBody.toJSONString()).post("https://reqres.in/api/users");
        Assert.assertEquals(response.statusCode(), 201);
        System.out.println(response.getBody().asString());

    }
}
