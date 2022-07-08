package app.hazina.app;

import app.hazina.entity.Transaction;
import app.hazina.service.TransactionService;
import app.hazina.app.dto.TransactionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountNumber}")
    public List<TransactionDto> findAllByAccountNumber(@PathVariable("accountNumber") final Integer accountNumber) {
        return transactionService.findAllByAccountNumber(accountNumber)
                .stream().map(this::map)
                .collect(toList());
    }

    private TransactionDto map(final Transaction tr) {
        return TransactionDto.apply(tr);
    }

    private final TransactionService transactionService;
}