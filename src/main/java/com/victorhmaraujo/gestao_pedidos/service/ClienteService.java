package com.victorhmaraujo.gestao_pedidos.service;

import com.victorhmaraujo.gestao_pedidos.dto.request.ClienteCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.entity.Cliente;
import com.victorhmaraujo.gestao_pedidos.exception.CustomerHasOrdersException;
import com.victorhmaraujo.gestao_pedidos.exception.ResourceAlreadyExistsException;
import com.victorhmaraujo.gestao_pedidos.exception.ResourceNotFoundException;
import com.victorhmaraujo.gestao_pedidos.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository database;

    public String cadastrarCliente(ClienteCadastroRequest data){

        if(database.existsByEmail(data.getEmail())) {
            throw new ResourceAlreadyExistsException("Não pode cadastrar o mesmo email!");
        };

        if(database.existsByCpf(data.getCpf())) {
            throw new ResourceAlreadyExistsException("Não pode cadastrar o mesmo cpf!");
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
        if(cliente == null) throw new ResourceNotFoundException("Esse cliente não existe!");
        if(!cliente.getPedidos().isEmpty()) throw new CustomerHasOrdersException("Esse cliente possui pedidos e não pode ser removido!") ;

        database.delete(cliente);
        return "Cliente removido!";
    }


    // Métodos Internos

    public Cliente getClienteById(Long id){
        return database.findById(id).orElse(null);
    }
}
