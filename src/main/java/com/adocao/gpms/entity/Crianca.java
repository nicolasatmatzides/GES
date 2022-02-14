package com.adocao.gpms.entity;

import com.adocao.gpms.model.Genero;
import lombok.*;
import com.adocao.gpms.model.AdocaoStatus;
import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "crianca")
public class Crianca {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private UUID id;

    @Column(name = "name")
    private String Name;

    @Column(name = "age")
    private String age;


    @Column(name = "address")
    private String address;

    @Column(name = "civil_id")
    private String civilId;

    @ManyToOne
    @JoinColumn(name = "siblings")
    private Siblings siblings;

    @Enumerated(EnumType.STRING)
    @Column(name = "adocao_status", nullable = false)
    private AdocaoStatus adocaoStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false)
    private Genero genero;

}