package com.adocao.gpms.model;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Usuario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class AdocaoDto {

    private String Id;


    private Crianca crianca;


    private Usuario usuario;


    private AdocaoStatus adocaoStatus;

}
