package app.hazina.service;

import app.hazina.HazinaApplication;
import app.hazina.service.TransactionService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;


@SpringBootTest(classes = {HazinaApplication.class})
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void testTransactionCount() {
        assertEquals(2, transactionService.findAllByAccountNumber(12345678).size());
    }
}