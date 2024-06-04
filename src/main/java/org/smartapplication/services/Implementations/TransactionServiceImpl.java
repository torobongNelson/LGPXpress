package org.smartapplication.services.Implementations;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.smartapplication.Config.BeanConfig;
import org.smartapplication.dtos.request.InitializeTransactionRequest;
import org.smartapplication.dtos.response.ApiResponse;
import org.smartapplication.dtos.response.paystack.PaystackTransactionResponse;
import org.smartapplication.model.Order;
import org.smartapplication.services.OrderServiceInterface;
import org.smartapplication.services.TransactionService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    private final OrderServiceInterface orderServiceInterface;
    private final BeanConfig beanConfig;

    @Override
    public ApiResponse<?> makePaymentFor(Long orderId) {
        RestTemplate restTemplate = new RestTemplate();
        Order foundOrder = orderServiceInterface.findBy(orderId);
        HttpEntity<InitializeTransactionRequest> request = buildPaymentRequest(foundOrder);
        ResponseEntity<PaystackTransactionResponse>response =
                restTemplate.postForEntity(beanConfig.getPaystackBaseUrl(), request, PaystackTransactionResponse.class);
        return new ApiResponse<>(response.getBody());
    }

    private HttpEntity<InitializeTransactionRequest> buildPaymentRequest(Order foundOrder) {
        InitializeTransactionRequest transactionRequest = new InitializeTransactionRequest();
        transactionRequest.setEmail(foundOrder.getCustomer().getEmail());
        transactionRequest.setAmount(foundOrder.getAmount());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer "+beanConfig.getPaystackApiKey());
        return new HttpEntity<>(transactionRequest, headers);
    }
}
