package app.hazina.app.dto;

import app.hazina.entity.Transaction;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class TransactionDto {
    private Long id;
    private String type;
    private Date date;
    private Integer accountNumber;
    private String currency;
    private Double amount;
    private String merchantName;
    private String merchantLogo;

    public static TransactionDto apply(final Transaction tr) {
        var t = new TransactionDtoBuilder()
                .id(tr.getId())
                .type(tr.getType())
                .accountNumber(tr.getAccountNumber())
                .currency(tr.getCurrency())
                .amount(tr.getAmount())
                .merchantName(tr.getMerchantName())
                .merchantLogo(tr.getMerchantLogo())
                .build();
        return t;
    }
}
