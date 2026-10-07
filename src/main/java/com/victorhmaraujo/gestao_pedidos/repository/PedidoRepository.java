package com.victorhmaraujo.gestao_pedidos.repository;

import com.victorhmaraujo.gestao_pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
