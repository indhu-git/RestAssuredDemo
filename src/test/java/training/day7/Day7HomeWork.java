package training.day7;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import training.utils.RestAPIUtilityClass;

import java.util.HashMap;
import java.util.Map;

public class Day7HomeWork {
//Board create -> Get Id of the borad -> Create more than 2 cards and delete all cards and boards.

    String baseURI = "https://api.trello.com/1/boards";
    Map<String, String> queryParams = new HashMap<>();

    String boardID = "RG0pqXo2";
    String idOrganization ="";

    Map<String, String> header = new HashMap<>();

    @Test
    public void createBoard(){
        queryParams.put("key", "3f2e4eca21e892561fdf169d912fd7ab");
        queryParams.put("token", "5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510");
        queryParams.put("name", "Board for API Automation");

        header.put("Content-Type","application/json" );
        header.put("Accept","application/json" );
        Response response = RestAssured.given().queryParams(queryParams).headers(header).post(baseURI);
        System.out.println(response.statusCode());
        System.out.println(response.getBody().asString());
        JSONObject jsonObject = RestAPIUtilityClass.getJsonObject(response.asString());
        Assert.assertEquals(response.statusCode(), 200);

        System.out.println(jsonObject);
//        boardID = jsonObject.get("id").toString();
        System.out.println(boardID);
    }

    @Test
    public void getBoard(){
        queryParams.put("key", "3f2e4eca21e892561fdf169d912fd7ab");
        queryParams.put("token", "5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510");
        Response response = RestAssured.given().queryParams(queryParams).headers(header).get(baseURI+"/"+boardID);
        Assert.assertEquals(response.statusCode(), 200);
        JSONObject jsonObject = RestAPIUtilityClass.getJsonObject(response.body().asString());
        System.out.println(jsonObject);
        idOrganization = jsonObject.get("idOrganization").toString();
        System.out.println(idOrganization);
    }


    @Test(dependsOnMethods = "getBoard")
    public void createCard(){
        queryParams.put("key", "3f2e4eca21e892561fdf169d912fd7ab");
        queryParams.put("token", "5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510");
        queryParams.put("idList", idOrganization);
        queryParams.put("name", "Card for automation");
        Response response = RestAssured.given().queryParams(queryParams).headers(header).get(baseURI+"/cards");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void deleteCards(){

    }

    @Test
    public void deleteBoard(){

    }
}
