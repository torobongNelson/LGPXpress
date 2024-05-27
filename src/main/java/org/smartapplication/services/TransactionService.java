package org.smartapplication.services;

import org.smartapplication.dtos.response.ApiResponse;

public interface TransactionService {
    ApiResponse<?> makePaymentFor(Long orderId);
}
