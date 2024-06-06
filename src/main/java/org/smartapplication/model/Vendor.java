package org.smartapplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
// import org.smartapplication.model.Enums.Location;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

// @Getter
// @Setter
@Entity
public class Vendor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotEmpty(message = "company name cannot be blank. If your business is not registered, use your first name")
    private String companyName;

    @NotEmpty(message = "company name cannot be blank.")
    private String companyAddress;

    private Boolean registrationStatus;

    // @Enumerated(EnumType.STRING)
    // private Location location;

    @NotEmpty(message = "business registration number cannot be blank.")
    private String  regNo;

    // @OneToOne
    // @JoinColumn(name = "user_id")
    // private User user;



}
