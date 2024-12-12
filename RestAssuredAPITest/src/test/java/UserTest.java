import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserTest {

    @Test
    public void UserCreate() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String bodyPayLoad = "{\n" +
                "    \"id\": 23422354,\n" +
                "    \"username\": \"zeynep3\",\n" +
                "    \"firstName\": \"zeynep3\",\n" +
                "    \"lastName\": \"sahin3\",\n" +
                "    \"email\": \"zeynep@gmail.com\",\n" +
                "    \"password\": \"abc123xxx\",\n" +
                "    \"phone\": \"05346284928\",\n" +
                "    \"userStatus\": 1\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .post("/v2/user")
                .then()
                .statusCode(200);
    }

    @Test
    public void getUserInfo() {
        UserCreate();
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .get("/v2/user/zeynep3")
                .then()
                .statusCode(200);
    }

    @Test
    public void UserUpdate() {
        RestAssured.baseURI = "https://petstore.swagger.io";

        String bodyPayLoad = "{\n" +
                "    \"id\": 23422355,\n" +
                "    \"username\": \"zeynep4\",\n" +
                "    \"firstName\": \"zeynep4\",\n" +
                "    \"lastName\": \"sahin4\",\n" +
                "    \"email\": \"zeynepp@gmail.com\",\n" +
                "    \"password\": \"abc123xxxx\",\n" +
                "    \"phone\": \"05346284929\",\n" +
                "    \"userStatus\": 0\n" +
                "}";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");
        headersPayLoad.put("Content-Type", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .body(bodyPayLoad)
                .when()
                .put("/v2/user/zeynep3")
                .then()
                .statusCode(200);
    }

    @Test
    public void UserDelete() {
        UserCreate();
        RestAssured.baseURI = "https://petstore.swagger.io";

        Map<String, String> headersPayLoad = new HashMap<>();
        headersPayLoad.put("accept", "application/json");

        RestAssured
                .given()
                .headers(headersPayLoad)
                .when()
                .delete("/v2/user/zeynep3")
                .then()
                .statusCode(200);
    }


}
