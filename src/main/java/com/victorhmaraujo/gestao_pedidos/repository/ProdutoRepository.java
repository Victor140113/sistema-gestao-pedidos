package com.victorhmaraujo.gestao_pedidos.repository;

import com.victorhmaraujo.gestao_pedidos.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Boolean existsByNome(String nome);
}
