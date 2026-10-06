package com.victorhmaraujo.gestao_pedidos.controller;

import com.victorhmaraujo.gestao_pedidos.dto.request.ProdutoCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.service.ProdutoService;
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
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping("/cadastro")
    public String cadastrarProduto(@Valid @RequestBody ProdutoCadastroRequest data){

        return service.cadastrarProduto(data);
    }

}
