package org.smartapplication.controller;

import org.smartapplication.dtos.request.InitializeTransactionRequest;
import org.smartapplication.dtos.response.paystack.PaystackTransactionResponse;
import org.smartapplication.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@RequestMapping("/api/payment")
public class TransactionController {
//    private final TransactionService transactionService;
//
//
//    public TransactionController(TransactionService transactionService) {
//        this.transactionService = transactionService;
//    }
//    @PatchMapping("/{orderId}")
//    public ResponseEntity<?> makePaymentFor(@PathVariable Long orderId) {
//        try {
//            return ResponseEntity.ok(transactionService.makePaymentFor(orderId));
//        }catch(Exception exception){
//            return ResponseEntity.badRequest().body(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
//        }
//    }
}
