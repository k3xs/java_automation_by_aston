import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoTestPut {

    @Test
    public void postmanEchoTestPut() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("person", "John Doe");

        given()
            .baseUri("https://postman-echo.com")
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .put("/put")
        .then()
            .statusCode(200)
            .body("data.person", equalTo("John Doe"))
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.x-forwarded-proto", equalTo("https"))
            .body("json.person", equalTo("John Doe"))
            .body("url", equalTo("https://postman-echo.com/put"));
    }
}
