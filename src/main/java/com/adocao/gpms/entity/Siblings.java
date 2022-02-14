package com.adocao.gpms.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "siblings")
public class Siblings {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Convert(disableConversion = true)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "crianca")
    private Crianca crianca;

}