package com.victorhmaraujo.gestao_pedidos.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoCadastroRequest {

    @NotBlank(message = "O nome do produto é obrigatório!")
    private String nome;

    @NotNull(message = "O preço não pode estar vazio!")
    @Positive(message = "O preço precisa ser positivo!")
    private BigDecimal preco;

    @NotNull(message = "A quantidade não pode estar vazia!")
    @PositiveOrZero(message = "A quantidade não pode ser menor do que 0!")
    private Integer quantidadeEstoque;
}
