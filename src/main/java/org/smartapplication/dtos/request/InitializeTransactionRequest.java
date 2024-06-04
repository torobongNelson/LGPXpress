package org.smartapplication.dtos.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class InitializeTransactionRequest {
    private String email;
    private BigDecimal amount;
}
