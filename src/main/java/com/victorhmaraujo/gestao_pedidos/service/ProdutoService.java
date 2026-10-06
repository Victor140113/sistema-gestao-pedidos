package com.victorhmaraujo.gestao_pedidos.service;

import com.victorhmaraujo.gestao_pedidos.dto.request.ProdutoCadastroRequest;
import com.victorhmaraujo.gestao_pedidos.entity.Produto;
import com.victorhmaraujo.gestao_pedidos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository database;

    public String cadastrarProduto(ProdutoCadastroRequest data){

        if(database.existsByNome(data.getNome())){
            return "O produto já existe!";
        }

        Produto novoProduto = new Produto();
        novoProduto.setNome(data.getNome());
        novoProduto.setPreco(data.getPreco());
        novoProduto.setQuantidadeEstoque(data.getQuantidadeEstoque());

        database.save(novoProduto);

        return "Produto cadastrado com sucesso!";
    }
}
