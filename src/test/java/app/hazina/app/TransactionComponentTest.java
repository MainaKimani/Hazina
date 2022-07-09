package app.hazina.app;
        /*---TESTING THE APPLICATION END TO END---*/

import app.hazina.HazinaApplication;
import app.hazina.app.TransactionController;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

@SpringBootTest(classes = {HazinaApplication.class})
public class TransactionComponentTest {

        @LocalServerPort
        private int port;

        @Autowired
        private TransactionController transactionController;

        @Test
        public void testApplicationEndToEnd() {
                given().standaloneSetup(transactionController)
                        .when()
                        .get(String.format("http://localhost:%s/api/transactions/123456", port))
                        .then()
                        .statusCode(Matchers.is(200));
        }
}
