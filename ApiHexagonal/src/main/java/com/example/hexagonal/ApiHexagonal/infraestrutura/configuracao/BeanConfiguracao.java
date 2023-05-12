package com.example.hexagonal.ApiHexagonal.infraestrutura.configuracao;

import com.example.hexagonal.ApiHexagonal.dominio.adaptadores.service.PedidoServiceImp;
import com.example.hexagonal.ApiHexagonal.dominio.portas.interfaces.ProdutoServicePort;
import com.example.hexagonal.ApiHexagonal.dominio.portas.repositores.ProdutoRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguracao {

    @Bean
    ProdutoServicePort produtoService(ProdutoRepositoryPort produtoRepositoryPort) {
        return new PedidoServiceImp(produtoRepositoryPort);
    }
}