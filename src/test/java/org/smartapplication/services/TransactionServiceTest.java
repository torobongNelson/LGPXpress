package org.smartapplication.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.smartapplication.dtos.response.ApiResponse;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;


@SpringBootTest
@Slf4j
public class TransactionServiceTest {
    private TransactionService transactionService;


    @Test
    public void testProcessPayment(){
        ApiResponse<?> response = transactionService.makePaymentFor(1L);
        log.info("res-->{}", response);
        assertNotNull(response);
    }
}
