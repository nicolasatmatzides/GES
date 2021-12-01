package com.adocao.gpms.entity;

import com.adocao.gpms.model.AdocaoStatus;
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
    private String Age;

    @Column
    private String Gender;

    @Column
    private String Address;

    @Column
    private String CivilId;

    @Column
    private AdocaoStatus adocaoStatus = AdocaoStatus.EMPTY;
}
