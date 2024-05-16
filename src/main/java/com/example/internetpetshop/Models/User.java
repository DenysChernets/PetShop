package com.example.internetpetshop.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    @Type(type = "uuid-char")
    private UUID Id;

    @Column(name = "username", unique = true)
    @NotEmpty
    @NotNull
    private String username;

    @Column(name = "email", unique = true)
    @Email
    @NotEmpty
    @NotNull
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordConfirm;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "city")
    private String city;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @Column(name = "balance")
    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Enumerated(EnumType.STRING)
    private Status status;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Order> orders;

    //    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
//    private User user;
    public User(String username,
                String email,
                String password,
                String passwordConfirm,
                String firstName,
                String lastName,
                int age,
                String city,
                Gender gender,
                BigDecimal balance,
                UserRole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
        this.gender = gender;
        this.balance = balance;
        this.role = role;
    }
}
