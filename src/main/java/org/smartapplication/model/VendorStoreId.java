package org.smartapplication.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class VendorStoreId {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @OneToOne
   @JoinColumn(name = "vendor_id")
   private Vendor vendor;


   private String storeId;

}
