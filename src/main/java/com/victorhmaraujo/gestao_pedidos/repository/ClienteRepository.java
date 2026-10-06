package com.victorhmaraujo.gestao_pedidos.repository;

import com.victorhmaraujo.gestao_pedidos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    public Boolean existsByEmail(String email);
    public Boolean existsByCpf(String cpf);
}
