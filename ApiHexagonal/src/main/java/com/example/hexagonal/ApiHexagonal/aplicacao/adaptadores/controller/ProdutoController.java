package com.example.hexagonal.ApiHexagonal.aplicacao.adaptadores.controller;

import com.example.hexagonal.ApiHexagonal.dominio.dtos.EstoqueDTO;
import com.example.hexagonal.ApiHexagonal.dominio.dtos.ProdutoDTO;
import com.example.hexagonal.ApiHexagonal.dominio.portas.interfaces.ProdutoServicePort;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoServicePort produtoServicePort;

    public ProdutoController(ProdutoServicePort produtoServicePort) {
        this.produtoServicePort = produtoServicePort;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void criarProdutos(@RequestBody ProdutoDTO produtoDTO) {
        produtoServicePort.criarProduto(produtoDTO);
    }

    @GetMapping
    List<ProdutoDTO> getProdutos() {
        return produtoServicePort.buscarProdutos();
    }

    @PutMapping(value = "/{sku}")
    void atualizarEstoque(@PathVariable String sku, @RequestBody EstoqueDTO estoqueDTO) throws ChangeSetPersister.NotFoundException {
        produtoServicePort.atualizarEstoque(sku, estoqueDTO);
    }
}