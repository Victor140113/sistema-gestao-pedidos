package com.victorhmaraujo.gestao_pedidos.controller;

import com.victorhmaraujo.gestao_pedidos.dto.request.ClienteCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.service.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    @PostMapping("/cadastro")
    public String cadastrarCliente(@Valid @RequestBody ClienteCadastroRequest data) {

        return service.cadastrarCliente(data);
    }

    @DeleteMapping("{id}")
    public String deletarCliente(@PathVariable Long id){

        return service.deletarCliente(id);
    }

}
