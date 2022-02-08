package com.adocao.gpms.entity;

import com.adocao.gpms.model.AdocaoStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;

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
    private String age;

    @Column
    private String gender;

    @Column
    private String Address;

    @Column
    private String CivilId;

    @ManyToOne
    private Siblings siblings;

    @Column
    private AdocaoStatus adocaoStatus;
}
