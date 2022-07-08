package app.hazina.app;
        /*---TESTING THE APPLICATION END TO END---*/

        import org.hamcrest.Matchers;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;
        import org.mockito.Mock;
        import org.mockito.MockitoAnnotations;
        import org.springframework.boot.test.web.server.LocalServerPort;
        import app.hazina.service.TransactionService;
        import app.hazina.repository.TransactionRepository;
        import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;

        public class TransactionComponentTest {
        @LocalServerPort
        private int port;

                @Mock
                private TransactionRepository transactionRepository;

                @BeforeEach
                public void setUp() {
                        MockitoAnnotations.openMocks(this);
                }

                @Test
                public void testApplicationEndToEnd() {
                        given().standaloneSetup(new TransactionController(new TransactionService(transactionRepository)))
                                .when()
                                .get(String.format("http://localhost:%s/api/transactions/1234567", port))
                                .then()
                                .statusCode(Matchers.is(200));
                }
        }
