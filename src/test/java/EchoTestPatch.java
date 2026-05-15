import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoTestPatch {

    @Test
    public void postmanEchoTestPatch() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("hello", "world");

        given()
            .baseUri("https://postman-echo.com")
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .patch("/patch")
        .then()
            .statusCode(200)
            .body("data.hello", equalTo("world"))
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.x-forwarded-proto", equalTo("https"))
            .body("json.hello", equalTo("world"))
            .body("url", equalTo("https://postman-echo.com/patch"));
    }
}
