package com.adocao.gpms.entity;

import com.adocao.gpms.model.AdocaoStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter

@NoArgsConstructor
public class Adocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    private Crianca crianca;

    @ManyToOne
    private Usuario usuario;

    @Column
    private AdocaoStatus adocaoStatus = AdocaoStatus.EMPTY;


}
