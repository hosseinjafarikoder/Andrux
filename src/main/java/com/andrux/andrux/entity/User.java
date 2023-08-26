package com.andrux.andrux.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int version;
    private long uniqueId;
    private String username;
    private String password;
    private String passwordConfirm;
    private Boolean ban;
    private boolean checkIsCustomer;
    private boolean checkIsBusinessOwner;
    private boolean checkIsManager;

    //metadata fields :
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private long lat;
    private long len;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();



}
