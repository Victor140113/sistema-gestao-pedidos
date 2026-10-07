package com.victorhmaraujo.gestao_pedidos.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoCriarRequest {

    @NotNull
    private Long donoId;

    @NotNull
    private List<ProdutoRequest> itens;
}
