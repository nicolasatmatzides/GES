package com.adocao.gpms.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DuvidaDTO {

    private Long idDuvida;
    @JsonProperty(value = "duvida")
    private String duvida;
    @JsonProperty(value = "resposta")
    private String resposta;
}
