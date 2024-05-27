package org.smartapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.PaymentMethod;
import org.smartapplication.model.Enums.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;


import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Transactions {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String transactionRef; //787t7yfeyf634t8724t27r87348762875478247268746828798
    private BigDecimal amount;      //15,000,000

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod; //CARD
    private LocalDateTime paymentDate; //2024-12-08
    private TransactionStatus status; // successful | failed

    @OneToOne
    @JoinColumn(name = "customer_id") // Mr Bola Tinubu []
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "order_id") //20
    private Order order;


}
