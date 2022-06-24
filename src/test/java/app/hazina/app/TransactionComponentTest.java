package app.hazina.app;
        /*---TESTING THE APPLICATION END TO END---*/

        import org.hamcrest.Matchers;
        import org.junit.jupiter.api.Test;
        import org.springframework.boot.test.web.server.LocalServerPort;
        import app.hazina.service.TransactionService;
        import app.hazina.app.TransactionController;

        import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
        import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

        public class TransactionComponentTest {
        @LocalServerPort
        private int port;

        @Test
        public void testAppEndToEnd(){
        given().standaloneSetup(new TransactionController(new TransactionService()))
        .when()
        .get(String.format("http://localhost:%s/api/v1/transactions/199578", port))
        .then()
        .statusCode(Matchers.is(200));
        }
        }
