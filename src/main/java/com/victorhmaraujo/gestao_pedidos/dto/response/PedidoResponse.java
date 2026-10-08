package com.victorhmaraujo.gestao_pedidos.dto.response;

import com.victorhmaraujo.gestao_pedidos.enums.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PedidoResponse {

    private LocalDateTime dataPedido;
    private StatusPedido status;
    private BigDecimal valorTotal;

}
