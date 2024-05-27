package org.smartapplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private Boolean isActive = false;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}
