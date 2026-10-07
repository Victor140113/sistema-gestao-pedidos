package com.victorhmaraujo.gestao_pedidos.service;

import com.victorhmaraujo.gestao_pedidos.dto.request.ClienteCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.entity.Cliente;
import com.victorhmaraujo.gestao_pedidos.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository database;

    public String cadastrarCliente(ClienteCadastroRequest data){

        if(database.existsByEmail(data.getEmail())) {
            System.out.println("Não pode cadastrar o mesmo email!");
        };

        if(database.existsByCpf(data.getCpf())) {
            System.out.println("Não pode cadastrar o mesmo cpf!");
        };

        Cliente novoCliente = new Cliente();
        novoCliente.setNome(data.getNome());
        novoCliente.setEmail(data.getEmail());
        novoCliente.setCpf(data.getCpf());

        database.save(novoCliente);
        return "Cliente cadastrado com sucesso!";

    }

    public String deletarCliente(Long id){

        Cliente cliente = database.findById(id).orElse(null);
        if(cliente == null) return "Esse cliente não existe!";
        if(!cliente.getPedidos().isEmpty()) return "Esse cliente possui pedidos, e não pode ser removido!";

        database.delete(cliente);
        return "Cliente removido!";
    }
}
