package com.victorhmaraujo.gestao_pedidos.controller;

import com.victorhmaraujo.gestao_pedidos.dto.request.ProdutoCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Getter
@Setter
@AllArgsConstructor
@Tag(name = "Produtos", description = "Endpoints de gerenciamento de produtos")
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @Operation(summary = "Cadastra um novo produto", description = "Cadastra um novo produto com os dados fornecidos")
    @ApiResponse(responseCode = "200", description = "Produto cadastrado com sucesso!")
    @PostMapping("/cadastro")
    public String cadastrarProduto(@Valid @RequestBody ProdutoCadastroRequest data){

        return service.cadastrarProduto(data);
    }

}
