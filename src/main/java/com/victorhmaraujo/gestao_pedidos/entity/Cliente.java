package com.victorhmaraujo.gestao_pedidos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    @Column(unique = true, length = 11)
    private String cpf;

    @NotNull
    @OneToMany(mappedBy = "donoPedido")
    private List<Pedido> pedidos;
}
