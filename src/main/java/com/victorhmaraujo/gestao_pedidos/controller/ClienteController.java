package com.victorhmaraujo.gestao_pedidos.controller;

import com.victorhmaraujo.gestao_pedidos.dto.request.ClienteCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Clientes", description = "Endpoints de gerenciamento de clientes")
@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    @Operation(summary = "Cadastra um cliente", description = "Cadastra um cliente com os dados fornecidos.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Cliente cadastrado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Dados do cliente inválidos!"),
            @ApiResponse(responseCode = "409", description = "O mesmo item não pode ser cadastrado!")
    })
    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarCliente(@Valid @RequestBody ClienteCadastroRequest data) {

        return ResponseEntity.status(201).body(service.cadastrarCliente(data));
    }

    @Operation(summary = "Remove um cliente", description = "Remove um cliente da base de dados, caso não haja pedidos vinculados a ele.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Cliente deletado com sucesso!"),
            @ApiResponse(responseCode = "404", description = "Cliente não encontrado!"),
            @ApiResponse(responseCode = "409", description = "O cliente possui pedidos e não pode ser excluído!")
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarCliente(@PathVariable Long id){

        return ResponseEntity.status(200).body(service.deletarCliente(id));
    }

}
