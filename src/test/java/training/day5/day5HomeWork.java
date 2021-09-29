package training.day5;


import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import training.utils.RestAPIUtilityClass;

public class day5HomeWork {

    String baseURI = "https://reqres.in/api/";

    @Test
    public void getExample(){
        Response response = RestAPIUtilityClass.get(baseURI+"users?page=2");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void postExample(){
        JSONObject input = new JSONObject();
        input.put("name", "Indhu");
        input.put("job", "Tester");
        Response response = RestAPIUtilityClass.post(baseURI+"users", input);
        JSONObject jsonObject = RestAPIUtilityClass.getJsonObject(response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertFalse(jsonObject.get("id").toString().equals(""));
    }
}
