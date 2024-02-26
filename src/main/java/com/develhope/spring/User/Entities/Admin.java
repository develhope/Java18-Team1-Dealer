package com.develhope.spring.User.Entities;

import jakarta.persistence.*;

@Entity
@Table
public class Admin extends User{
    public Admin(Long id, String firstName, String lastName, String email, String password) {
        super(id, firstName, lastName, email, password);
    }

    public Admin() {
    }
}
