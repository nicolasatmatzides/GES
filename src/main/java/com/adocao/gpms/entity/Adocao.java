package com.adocao.gpms.entity;

import com.adocao.gpms.model.AdocaoStatus;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "adocao")
public class Adocao {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "crianca")
    private Crianca crianca;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "adocaoStatus", nullable = false, unique = true)
    private AdocaoStatus adocaoStatus;

}