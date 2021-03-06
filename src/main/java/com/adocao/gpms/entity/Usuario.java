package com.adocao.gpms.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    private String Name;

    @Column
    private int Age;

    @Column
    private String Gender;

    @Column
    private String Address;

    @Column
    private String CivilId;

    @Column
    private String cpf;

    @Column
    private Boolean active;
}
