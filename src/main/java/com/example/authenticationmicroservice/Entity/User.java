package com.example.authenticationmicroservice.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
public class User {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * email
     */
    private String email;

    /**
     * email
     */
    private String password;

    /**
     * username
     */
    private String username;

    /**
     * lis of roles
     */
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles = new ArrayList<>();


}
