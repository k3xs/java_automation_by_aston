import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoTestDelete {

    @Test
    public void postmanEchoTestDelete() {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("id", "123");

        given()
            .baseUri("https://postman-echo.com")
            .contentType(ContentType.JSON)
            .body(requestBody)
        .when()
            .delete("/delete")
        .then()
            .statusCode(200)
            .body("data.id", equalTo("123"))
            .body("headers.host", equalTo("postman-echo.com"))
            .body("headers.x-forwarded-proto", equalTo("https"))
            .body("json.id", equalTo("123"))
            .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
