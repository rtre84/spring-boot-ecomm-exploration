package com.springlearning.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAccount {

    public UserAccount (String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }

    @Id
    @GeneratedValue
    Long id;

    String username;

    String password;

    boolean active;
}
