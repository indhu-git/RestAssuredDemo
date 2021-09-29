package training.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestAPIUtilityClass {

    public static Response get(String uri) {
        Response response = null;
        try {
            response = RestAssured.get(uri);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return response;
    }
    public static Response delete(String uri) {
        Response response = null;
        try {
            response = RestAssured.delete(uri);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return response;
    }

    public static Response put(String uri) {
        Response response = null;
        try {
            response = RestAssured.put(uri);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return response;
    }
    public static Response post(String uri, JSONObject jsonObject) {
        Response response = null;
        try {

            response = RestAssured.given().body(jsonObject.toJSONString()).post(uri);
        }catch (Throwable t){
            t.printStackTrace();
        }
        return response;
    }

    public static JSONObject getJsonObject(String response) {
        JSONObject jsonObject = null;
        try {
            JSONParser parser = new JSONParser();
            jsonObject = (JSONObject) parser.parse(response);
        }catch (Throwable t){

        }
        return jsonObject;
    }
}
