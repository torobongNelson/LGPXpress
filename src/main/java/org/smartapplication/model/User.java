package org.smartapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.smartapplication.model.Enums.Roles;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @NotEmpty(message = "first name cannot be null")
    private String firstName;

    @NotEmpty(message = "last name cannot be null")
    private String lastName;

    @Email(message = "enter a valid email")
    @NotBlank(message = "email cannot be blank")
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    @NotEmpty(message = "phoneNo cannot be blank")
    private String phone;

    @NotEmpty(message = "password cannot be blank" )
    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @CreationTimestamp
    @Column(name = "created_at",nullable= false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
