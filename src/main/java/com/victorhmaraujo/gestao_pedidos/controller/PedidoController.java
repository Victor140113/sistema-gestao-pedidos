package com.victorhmaraujo.gestao_pedidos.controller;

import com.victorhmaraujo.gestao_pedidos.dto.request.PedidoCriarRequest;
import com.victorhmaraujo.gestao_pedidos.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    @PostMapping
    public String criarPedido(@RequestBody PedidoCriarRequest data){
        return service.criarPedido(data);
    }
}
