package com.example.hexagonal.ApiHexagonal.dominio.portas.repositores;

import com.example.hexagonal.ApiHexagonal.dominio.Produto;

import java.util.List;

public interface ProdutoRepositoryPort {
    List<Produto> buscarTodos();

    Produto buscarPeloSku(String sku);

    void salvar(Produto produto);
}