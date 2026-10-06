package com.victorhmaraujo.gestao_pedidos.entity;

import com.victorhmaraujo.gestao_pedidos.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;
    private StatusPedido status;
    private BigDecimal valorTotal;

    public BigDecimal calcularTotal(){

        return null;
    }
}
