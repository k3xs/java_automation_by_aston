import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoTestPost {

    @Test
    public void postmanEchoTestPost() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("test", "value");

        given()
            .baseUri("https://postman-echo.com")
            .body(requestBody)
        .when()
            .post("/post")
        .then()
            .statusCode(200)
            .body("data",equalTo("{\"test\":\"value\"}"))
            .body("headers.host", equalTo("postman-echo.com"))
            .body("json", equalTo(null))
            .body("url", equalTo("https://postman-echo.com/post"));
    }
}
