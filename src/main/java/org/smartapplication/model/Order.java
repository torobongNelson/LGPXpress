package org.smartapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty(message = "delivery address cannot be blank")
    private String deliveryAddress;

    @NotEmpty(message = " phoneNo cannot be blank")
    private String phoneNumber;

    private BigDecimal total;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    private List<OrderItems> products;

    private Boolean isPaid = false;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
