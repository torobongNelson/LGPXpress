package org.smartapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.smartapplication.model.Enums.Location;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty(message = "Delivery address cannot be blank")
    private String address;

    @Enumerated(EnumType.STRING)
    private Location location;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(mappedBy = "customer")
    private Transactions transaction;

    @OneToOne(mappedBy = "customer")
    private  Order orders;


    private String email;


}
