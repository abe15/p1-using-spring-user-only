package com.revature.springpractice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ers_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ers_users_id")
    @Positive
    private int userId;

    @NotNull
    @Column(name = "user_first_name")
    private String firstName;

    @NotNull
    @Column(name = "user_last_name")
    private String lastName;

    @NotNull
    @Column(name = "ers_username")
    private String username;

    @NotNull
    @Column(name = "user_email")
    private String email;

    @NotNull
    @Column(name = "ers_password")
    private String password;

    @NotNull
    @Column(name = "user_role_id")
    private Integer userRoleId;

}
