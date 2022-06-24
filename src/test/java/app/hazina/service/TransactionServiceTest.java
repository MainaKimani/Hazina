package app.hazina.service;

/*---service.TransactionServiceTest.java
 ----Unit testing TransactionService using junit
*/
import org.junit.jupiter.api.Test;
import app.hazina.service.TransactionService;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TransactionServiceTest {

    //Creation of TransactionService object
    TransactionService transactionService = new TransactionService();

    //Testing the numbers need to match with what you expect in the test class
    @Test
    public void testTransactionCount() {
        assertEquals(1, transactionService.findAllByAccountNumber(199578).size());
    }
}
