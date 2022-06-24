package app.hazina.app;

import app.hazina.HazinaApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {HazinaApplication.class})
@AutoConfigureMockMvc // Enable and configure auto-configuration of MockMvc
public class TransactionControllerIntegrationTest {

    @Test
    public void testTransactions() throws Exception{
        mockMvc.perform(
                        get("/api/v1/transactions/199578"))
                .andExpect(status().isOk());
    }
    @Autowired
    private MockMvc mockMvc;
}
