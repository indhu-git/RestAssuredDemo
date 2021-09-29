package training.day5;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day5ClassExample {
    String baseURI = "https://reqres.in/api";

    @Test
    public void day5GetExample() throws ParseException {
        Response response = RestAssured.get(baseURI+"/users?page=2");
        Assert.assertEquals(response.statusCode(), 200);
        JSONObject jsonObject = getJsonObject(response.getBody().asString());
        String page = jsonObject.get("page").toString();
        System.out.println(page);
        Assert.assertEquals(page, "2");
    }
    @Test
    public void day5PostExample() throws ParseException {
        JSONObject input = new JSONObject();
        input.put("name", "Indhu");
        input.put("job", "Tester");
        Response response = RestAssured.given().body(input.toJSONString()).post(baseURI+"/users");
        Assert.assertEquals(response.statusCode(), 201);
        JSONObject outputJson = getJsonObject(response.getBody().asString());
        String idValue = outputJson.get("id").toString();
        Assert.assertEquals(idValue, "289");
        Response response1 = RestAssured.get(baseURI+"/users/"+idValue);
        Assert.assertEquals(response1.statusCode(), 404);
    }


    public JSONObject getJsonObject(String response) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject)parser.parse(response);
        return jsonObject;
    }
}
