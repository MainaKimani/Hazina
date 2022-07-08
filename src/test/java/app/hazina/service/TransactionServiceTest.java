package app.hazina.service;

import app.hazina.entity.Transaction;
import app.hazina.repository.TransactionRepository;
import app.hazina.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testTransactionCount() {
        when(transactionRepository.findAllByAccountNumber(anyInt()))
                .thenReturn(transactions());

        var transactionService = new TransactionService(transactionRepository);
        assertEquals(1, transactionService.findAllByAccountNumber(1234567).size());
    }

    private List<Transaction> transactions() {
        return List.of(
                Transaction
                        .builder()
                        .type("credit")
                        .date(new Date())
                        .accountNumber(1234567)
                        .currency("Ksh. ")
                        .amount(1000.00)
                        .merchantName("Equity")
                        .merchantLogo("")
                        .build()
        );
    }
}