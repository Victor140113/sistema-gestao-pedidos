package com.victorhmaraujo.gestao_pedidos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ItemPedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantidade;
    private BigDecimal precoUnitario;

    @ManyToOne
    private Pedido pedido;

    @ManyToOne
    private Produto produto;

    public ItemPedido(Produto produto, Integer quantidade, Pedido pedido){
        this.produto = produto;
        this.quantidade = quantidade;
        this.pedido = pedido;
    }

    public BigDecimal calcularSubTotal(){
        return this.precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
