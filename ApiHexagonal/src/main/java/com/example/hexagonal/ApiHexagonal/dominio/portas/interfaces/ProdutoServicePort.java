package com.example.hexagonal.ApiHexagonal.dominio.portas.interfaces;

import com.example.hexagonal.ApiHexagonal.dominio.dtos.EstoqueDTO;
import com.example.hexagonal.ApiHexagonal.dominio.dtos.ProdutoDTO;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface ProdutoServicePort {

    List<ProdutoDTO> buscarProdutos();

    void criarProduto(ProdutoDTO produtoDTO);

    void atualizarEstoque(String sku, EstoqueDTO estoqueDTO) throws ChangeSetPersister.NotFoundException;
}
