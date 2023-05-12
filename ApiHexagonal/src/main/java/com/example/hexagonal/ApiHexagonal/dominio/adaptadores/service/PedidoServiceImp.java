package com.example.hexagonal.ApiHexagonal.dominio.adaptadores.service;

import com.example.hexagonal.ApiHexagonal.dominio.Produto;
import com.example.hexagonal.ApiHexagonal.dominio.dtos.EstoqueDTO;
import com.example.hexagonal.ApiHexagonal.dominio.dtos.ProdutoDTO;
import com.example.hexagonal.ApiHexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.example.hexagonal.ApiHexagonal.dominio.portas.repositores.ProdutoRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PedidoServiceImp implements ProdutoServicePort {

    private final ProdutoRepositoryPort produtoRepository;

    public PedidoServiceImp(ProdutoRepositoryPort produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void criarProduto(ProdutoDTO produtoDTO) {
        Produto produto = new Produto(produtoDTO);
        this.produtoRepository.salvar(produto);
    }

    @Override
    public List<ProdutoDTO> buscarProdutos() {
        List<Produto> produtos = this.produtoRepository.buscarTodos();
        List<ProdutoDTO> produtoDTOS = produtos.stream().map(Produto::toProdutoDTO).collect(Collectors.toList());
        return produtoDTOS;
    }

    @Override
    public void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws EntityNotFoundException {
        Produto produto = this.produtoRepository.buscarPeloSku(sku);

        if (Objects.isNull(produto))
            throw new EntityNotFoundException("Produto não encontrado");

        produto.atualizarEstoque(estoqueDTO.getQuantidade());

        this.produtoRepository.salvar(produto);
    }
}