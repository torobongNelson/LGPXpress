package org.smartapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@Table(name = "order_items")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ORDER_ITEMS_ORDER"))
    private Order order;


    @NotEmpty(message = "quantity cannot be blank")
    private Integer quantity;
}
