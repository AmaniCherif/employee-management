package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class NotificationResourceTest {

    @Test
    public void notifications() throws InterruptedException {
        Thread.sleep(1000); // wait at least a second to have the first task created
        given()
                .when().get("/notifications/notif")
                .then()
                .statusCode(200);
    }
}
