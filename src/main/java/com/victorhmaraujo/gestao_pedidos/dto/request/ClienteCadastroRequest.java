package com.victorhmaraujo.gestao_pedidos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCadastroRequest {

    @NotBlank(message = "O nome é obrigatório!")
    private String nome;

    @Email(message = "Precisa estar em formato email (ex: fulano@gmail.com")
    @NotBlank(message = "O email é obrigatório!")
    private String email;

    @NotBlank(message = "O CPF é obrigatório!")
    private String cpf;
}
