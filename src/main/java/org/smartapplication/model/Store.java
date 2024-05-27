package org.smartapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Store {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String storeId; //T-gurl, generate dis in your serviceClass for the vendor and is unique

    private Long VendorId;

    private Long productId;
}
