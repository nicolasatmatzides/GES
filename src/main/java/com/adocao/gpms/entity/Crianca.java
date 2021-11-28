package com.adocao.gpms.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Crianca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Adocao adocao;
}
