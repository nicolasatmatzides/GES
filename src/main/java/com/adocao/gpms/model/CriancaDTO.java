package com.adocao.gpms.model;

import com.adocao.gpms.entity.Siblings;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriancaDTO {

    private String id;

    private String Name;

    private String age;

    private String gender;

    private String NomeCompletoMae;

    private String NomeCompletoPai;

    private String CPF;

    private String Address;

    private String DataNascimento;

    private Siblings siblings;

    private AdocaoStatus adocaoStatus;

}
