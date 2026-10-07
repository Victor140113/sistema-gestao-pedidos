package com.victorhmaraujo.gestao_pedidos.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProdutoRequest {

    @NotNull
    private Long id;

    @NotNull
    private int quantidade;
}
