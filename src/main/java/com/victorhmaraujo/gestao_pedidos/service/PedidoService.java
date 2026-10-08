package com.victorhmaraujo.gestao_pedidos.service;

import com.victorhmaraujo.gestao_pedidos.dto.request.PedidoCriarRequest;
import com.victorhmaraujo.gestao_pedidos.dto.request.ProdutoRequest;
import com.victorhmaraujo.gestao_pedidos.dto.response.PedidoResponse;
import com.victorhmaraujo.gestao_pedidos.entity.Cliente;
import com.victorhmaraujo.gestao_pedidos.entity.ItemPedido;
import com.victorhmaraujo.gestao_pedidos.entity.Pedido;
import com.victorhmaraujo.gestao_pedidos.entity.Produto;
import com.victorhmaraujo.gestao_pedidos.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PedidoService {

    private final PedidoRepository database;
    private final ClienteService clienteService;
    private final ProdutoService produtoService;

    public String criarPedido(PedidoCriarRequest data){

        Cliente donoPedido = clienteService.getClienteById(data.getDonoId());
        if (donoPedido == null) return "Cliente não cadastrado";

        Pedido novoPedido = new Pedido();
        List<ItemPedido> listaItens = new ArrayList<>();

        for(ProdutoRequest produto : data.getItens()){

            Produto produtoBanco = produtoService.getProdutoById(produto.getId());
            listaItens.add(new ItemPedido(produtoBanco, produto.getQuantidade(), novoPedido, produtoBanco.getPreco()));
        }

        novoPedido.setItens(listaItens);
        novoPedido.setDonoPedido(donoPedido);
        database.save(novoPedido);

        return "Pedido criado com sucesso!";
    }

    public List<PedidoResponse> listarPedidos(Long clienteId){

        Cliente donoPedido = clienteService.getClienteById(clienteId);
        return database.findAllByDonoPedido(donoPedido).stream().map( pedido -> new PedidoResponse(pedido.getDataPedido(), pedido.getStatus(), pedido.getValorTotal())).toList();
    }
}
