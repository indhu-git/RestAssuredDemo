package training.day6;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import training.utils.RestAPIUtilityClass;

public class TrelloExampleRestAssured {
    String baseURI = "https://api.trello.com/1/boards/IzZ7uQ8c?key=3f2e4eca21e892561fdf169d912fd7ab&token=5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510";
    @Test
    public void getMyDetails(){
        Response response = RestAPIUtilityClass.get("https://api.trello.com/1/members/me?key=3f2e4eca21e892561fdf169d912fd7ab&token=5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510");
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void get(){
        Response response = RestAPIUtilityClass.get(baseURI);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void update(){
        Response response = RestAPIUtilityClass.put(baseURI+"&name=day6_updated&@desc=description_updated");
        System.out.println(response.getBody().asString());
    }
    @Test
    public void delete(){
        Response response = RestAPIUtilityClass.delete(baseURI);
        System.out.println(response.getBody().asString());
    }

    @Test
    public void post(){
        Response response = RestAssured.given()
                .queryParam("name", "BoardName for test2")
                .queryParam("key", "3f2e4eca21e892561fdf169d912fd7ab")
                .queryParam("token", "5e5dfafaf970000aed474bacdf1ed68cae1bc37a1b10471d19faabbc8fca5510")
                .header("Content-Type","application/json" )
                .header("Accept","application/json" )
                .post("https://api.trello.com/1/boards");
        Assert.assertEquals(response.statusCode(), 200);
        System.out.println(response.getBody().asString());



    }

}
