package com.victorhmaraujo.gestao_pedidos.controller;

import com.victorhmaraujo.gestao_pedidos.dto.request.PedidoCriarRequest;
import com.victorhmaraujo.gestao_pedidos.dto.response.PedidoResponse;
import com.victorhmaraujo.gestao_pedidos.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Tag(name = "Pedidos", description = "Endpoints de gerenciamento de pedidos")
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    @Operation(summary = "Cria pedidos", description = "Cria pedidos com os dados fornecidos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Pedido criado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "O dono do pedido não existe!")
    })
    @PostMapping
    public String criarPedido(@RequestBody PedidoCriarRequest data){
        return service.criarPedido(data);
    }

    @Operation(summary = "Lista todos os pedidos", description = "Lista todos os pedidos de determinado cliente")
    @ApiResponse(responseCode = "200", description = "Lista de pedidos devolvida!")
    @GetMapping("{clienteId}")
    public List<PedidoResponse> listarPedidos(@PathVariable Long clienteId){

        return service.listarPedidos(clienteId);
    }
}
