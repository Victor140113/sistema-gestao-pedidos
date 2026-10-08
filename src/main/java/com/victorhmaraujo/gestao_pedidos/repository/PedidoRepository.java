package com.victorhmaraujo.gestao_pedidos.repository;

import com.victorhmaraujo.gestao_pedidos.entity.Cliente;
import com.victorhmaraujo.gestao_pedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    public List<Pedido> findAllByDonoPedido(Cliente donoPedido);
}
