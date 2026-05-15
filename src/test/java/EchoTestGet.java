import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EchoTestGet {

    @Test
    public void postmanEchoTestGet() {
        Map<String, String> params  = new HashMap<>();
        params.put("foo1", "bar1");
        params.put("foo2", "bar2");

        given()
                    .baseUri("https://postman-echo.com")
                    .queryParams(params)
                .when()
                    .get("/get")
                .then()
                    .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", equalTo("gzip, br"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }
}
