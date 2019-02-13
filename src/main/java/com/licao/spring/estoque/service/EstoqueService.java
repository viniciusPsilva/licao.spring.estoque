package com.licao.spring.estoque.service;

import java.util.Optional;

import com.licao.spring.Entidades.models.Estoque;

public interface EstoqueService extends Service<Estoque>{
	
	public Estoque atualizarStatus(Estoque estoque)throws Exception;

	public Estoque atualizarQuantidade(Estoque estoque, int quantidade) throws Exception;
	
	public Optional<Estoque> buscarEstoquePorIdProduto(Integer idProduto);
}
